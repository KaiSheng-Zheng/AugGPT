package com.auggpt.controller;

import com.auggpt.model.*;
import com.auggpt.service.*;
import com.auggpt.utils.*;
import com.auggpt.model.PromptType;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.utils.CommandLineUtils.run_cmd;
import static com.auggpt.service.CompileService.compile;
import static com.auggpt.utils.IOUtils.cleanUp;
import static com.auggpt.utils.IOUtils.*;
import static com.auggpt.utils.MiscUtils.countTests;
import static com.auggpt.utils.PDFParser.parsePDFtoString;
import static com.auggpt.utils.TestClassFileBuilder.splitCode;
import static org.junit.jupiter.api.Assertions.fail;


@Slf4j
public class MainController {

    private static ResourceBundle autogen;
    private static HashMap<String, String> systemProperties;
    private static EvaluationService evaluationService;
    private final Scanner scanner = new Scanner(System.in);
    private final TestClassFileBuilder classFileBuilder = new TestClassFileBuilder();
    private TestClassFileBuilder tmpClassFileBuilder = new TestClassFileBuilder();
    private final String NAME = "Agent1";


    /**
     * Launch AugGPT
     */
    public void launch() {
        //0. launch
        log.info(FancyOutput.SYSTEM_LAUNCH.getStr());
        log.info("AugGPT is launched at: " + MiscUtils.getNow());
        Locale.setDefault(new Locale("en", "US"));

        boolean err = false;

        log.info("Please enter your OpenAI API key:");
        String api = "sk-axbE1h6GcG0tEh0L6gesZirm3kpFXx87GWJshgjs4Fv8DTyK";
//        String api = scanner.next();

        MultiAgentManager multiAgentManager = MultiAgentManager.getInstance();

        err = multiAgentManager.putAgent(NAME, AgentType.GPT_4o_MINI, api);
        CHECKERR(err);

        log.info("CharGPT service initialize success!");
        //1. read configuration
        systemProperties = new HashMap<>();
        autogen = ResourceBundle.getBundle("auggpt", Locale.getDefault());
        loadSystemProperties();

        initialize();

        //2.1 compile source program
        cleanUp(systemProperties.get("targetPath"),false);
        err = compile(systemProperties.get("programRootPath"), systemProperties.get("libPath"),
                systemProperties.get("targetPath"), systemProperties.get("programRootPath"));
        CHECKERR(err);

        //2.2 read pdf
        String PDFContent = parsePDFtoString(getPropertiesString(autogen, "pdfInputPath"));

        evaluationService =
                EvaluationService.getInstance(systemProperties);

        ArrayList<Integer> respPointer = new ArrayList<>();
        ArrayList<String> responses = new ArrayList<>();

        String msg = "";
        String response = "";

        msg = PromptUtils.prompting(List.of(PDFContent), PromptType.RAW_PDF_SUBMIT);
        String resp1 = multiAgentManager.chat(NAME, msg, responses, respPointer);

        //3.2 prepare for refine loop
        boolean interrupt = false;
        String nonCoveredInfo;
        Map<String,ArrayList<String>> mutInfo;
        String compileInfo;

        testPreprocess(tmpClassFileBuilder);

        nonCoveredInfo   = evaluationService.getNonCoveredInfo();
        mutInfo          = evaluationService.getMutationInfo();
        compileInfo      = CompileService.getCompileInfoString();

        double lastEval = 0.0;
        double lastMuKill = 0.0;
        int cnt = 0;

        while(!interrupt) {
            tmpClassFileBuilder = new TestClassFileBuilder();
            tmpClassFileBuilder.append(classFileBuilder,false);

            int tot = nonCoveredInfo.length();
            int sep = tot + 1;

            // we disabled it, but you may want to break the non-covered information into several parts.
//            if (tot>60000){
//                sep = tot/3+rd.nextInt(2048);
//            }
//            else if (tot>10000){
//                sep = tot/2+rd.nextInt(256);
//            }
//            else if (tot>6000) {
//                sep = tot/1 +rd.nextInt(128);
//            }
//            else{
//                sep = tot +rd.nextInt(256);
//            }

            log.info("refining...");
            log.info("total length: {}",tot);

            int max = (int) Math.ceil(tot/(double)sep);

            ArrayList<String> strs = new ArrayList<>();
            for (int i = 0; i < max; i++) {

                log.info("iter: {}/{}",i,max);
                int sepMin = Math.min(tot, (i + 1) * sep);
                String subNCInfo = nonCoveredInfo.substring(i * sep, sepMin);
                String mutInfoStr = mutInfoFilter(nonCoveredInfo, mutInfo);

                log.info("mutant info length: {}",mutInfoStr.length());
                log.info("compile info length: {}",compileInfo.length());

                msg = PromptUtils.prompting(List.of(
                        subNCInfo,
                        mutInfoStr,
                        compileInfo
                ), PromptType.REFINE_GET_CODE);
                response = multiAgentManager.regenerate(NAME, msg, responses, respPointer);
                if (!response.contains("```")){
                    i--;
                    continue;
                }
                tmpClassFileBuilder.appendClass(MiscUtils.codeBlockFormatter(response));
                strs.add(MiscUtils.codeBlockFormatter(response));
            }

            String cp = testPreprocess(tmpClassFileBuilder);
            if (cp.equals(Code.EVALUATION_COMPILE_ERROR.name())){
                continue;
            }

            nonCoveredInfo   = evaluationService.getNonCoveredInfo();
            mutInfo          = evaluationService.getMutationInfo();
            compileInfo      = CompileService.getCompileInfoString();

            double thisEval = EvaluationService.getMutationResults().get(MutationTester.LC);
            double thisKill = EvaluationService.getMutationResults().get(MutationTester.MU_KILL_RATE);
            int maxTolCnt = Integer.parseInt(systemProperties.get("maxRejectTolerance"));
            if ((thisEval - lastEval <= 0.001 && thisKill - lastMuKill <= 0.001) && cnt<maxTolCnt) {
                log.info("No improve, try again. {}/{}",cnt,maxTolCnt);
                cnt++;
            } else {
                log.info("accepted");
                for(String content: strs)
                    classFileBuilder.appendClass(content);
                lastEval = thisEval;
                lastMuKill = thisKill;
                interrupt = isInterrupt();
                cnt = 0;
            }
        }

        //4. provide a final result
        testPreprocess(classFileBuilder);

        Code evaluateResult = evaluationService.compileAndEvaluate();

        //5. output and cleanup
        multiAgentManager.closeAll();
        log.info("Finish generation. Please check the test files at {}\n",systemProperties.get("testPath"));
        log.info("-----------------------------------------------");
//        System.exit(0);

    }

    private String mutInfoFilter(String nonCoveredInfo, Map<String,ArrayList<String>> mutInfo) {
        Pattern methodPattern = Pattern.compile(TestClassFileBuilder.methodPattern);
        Matcher matcher = methodPattern.matcher(nonCoveredInfo);
        StringBuilder sb = new StringBuilder();

        while(matcher.find()){
            String methodName = matcher.group(3);
            ArrayList<String> muts = mutInfo.get(methodName);
            if (muts==null) continue;
            sb.append(methodName).append(": ");
            ArrayList<String> shufMuts = new ArrayList<>(muts);
            Collections.shuffle(shufMuts);

            for (String mut : shufMuts) {
                sb.append(mut).append(",\n");
                if (sb.length() > 500) {
                    return sb.toString();
                }
            }
        }

        return sb.toString();
    }

    private void initialize() {
        log.info("The system is launched at {}",systemProperties.get("repoPath"));

        File dir = new File(systemProperties.get("rootPath"));
        if (!dir.exists()){
            log.info("data directory does not exist, creating");
            dir.mkdirs();
        }

        dir = new File(systemProperties.get("libPath"));
        if (!dir.exists()){
            log.info("lib directory not exist, creating");
            dir.mkdirs();
        }

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files==null || files.length==0){
                log.error("lib directory is empty, will cause compilation error later!");
                log.error("Please add required dependencies, including JUnit4, JUnit5, PITest as minimum requirement and other necessary jars.");
                log.error("Dependencies can be downloaded in ");
                System.exit(1);
            }
        }

        dir = new File(systemProperties.get("corePath"));
        if (!dir.exists()){
            log.info("script directory does not exist, creating");
            dir.mkdirs();
        }
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files==null || files.length==0){
                log.info("script directory is empty, creating script file");
                File pitScript = new File(systemProperties.get("corePath")+"\\\\PIT_script_raw.bat");
                IOUtils.writeFile(pitScript.getAbsolutePath(), EvaluationService.PIT_RAW_SCRIPT);
            }
        }


        dir = new File(systemProperties.get("targetPath"));
        if (!dir.exists()){
            log.info("Target directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("testPath"));
        if (!dir.exists()){
            log.info("Test directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("GPTTestPath"));
        if (!dir.exists()){
            log.info("System output directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("PITReportPath"));
        if (!dir.exists()){
            log.info("PITest report output directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("tempJavaFilePath"));
        if (!dir.exists()){
            log.info("Temp directory does not exist, creating");
            dir.mkdirs();
        }

        loadThreshold();
        log.info("Initialization finish");
    }

    private double lastResult = 1;
    private int runCnt = 0;
    private int failedIterCnt = 0;
    private int iterationThreshold;
    private int testNumberThreshold;
    private double minCoverageImproveThreshold;
    private int failedIterationThreshold;

    private void loadThreshold(){
        iterationThreshold = Integer.parseInt(systemProperties.getOrDefault("iterationThreshold","4"));
        testNumberThreshold = Integer.parseInt(systemProperties.getOrDefault("testNumberThreshold","50"));
        minCoverageImproveThreshold = Double.parseDouble(systemProperties.getOrDefault("minCoverageImproveThreshold","0.001"));
        failedIterationThreshold = Integer.parseInt(systemProperties.getOrDefault("failedIterationThreshold","2"));
    }
    private boolean isInterrupt() {
        Map<String, Double> resultMap = evaluationService.getCoverageResults();
        double result = resultMap.get(CoverageMetrics.INSTRUCTION.name());
        runCnt++;

        boolean reachIterLimit = iterationThreshold > 0 && runCnt >= iterationThreshold;
        if (reachIterLimit) return true;

        int testNum = countTests(classFileBuilder.getResult());
        log.info("Current test number: {}",testNum);
        boolean reachTestNumLimit = testNumberThreshold > 0 && testNum >= testNumberThreshold;
        if (reachTestNumLimit) return true;

        // have not reached the limitation of iteration or test number, then check whether it has improved.
        boolean improveFlag = result - lastResult <= minCoverageImproveThreshold;
        boolean failToImprove = false;
        if (improveFlag){
            // if failed to improve for a certain number of iterations, interrupt.
            failedIterCnt++;
            if (failedIterCnt >= failedIterationThreshold){
                failToImprove = true;
            }
        } else {
            failedIterCnt = 0;
        }
        lastResult = result;

        return failToImprove;
    }

    /**
     * Plain approach
     */
    public void plain() {
        //0. Launch message
        log.info(FancyOutput.SYSTEM_LAUNCH.getStr());
        log.info("System is launched at: " + MiscUtils.getNow());
        log.info("The system is running with plain approach!");

        systemProperties = new HashMap<>();
        autogen = ResourceBundle.getBundle("auggpt", Locale.getDefault());
        loadSystemProperties();

        initialize();

        boolean err = false;

        log.info("Please enter your ChatGPT api key:");
        String api = "sk-axbE1h6GcG0tEh0L6gesZirm3kpFXx87GWJshgjs4Fv8DTyK";

        MultiAgentManager multiAgentManager = MultiAgentManager.getInstance();

        err = multiAgentManager.putAgent(NAME, AgentType.GPT_4o_MINI, api);
        CHECKERR(err);

        log.info("CharGPT service initialize success!");

        cleanUp(systemProperties.get("targetPath"),false);
        err = compile(systemProperties.get("programRootPath"), systemProperties.get("libPath"),
                systemProperties.get("targetPath"), systemProperties.get("programRootPath"));
        CHECKERR(err);

        evaluationService =
                EvaluationService.getInstance(systemProperties);

        ArrayList<Integer> respPointer = new ArrayList<>();
        ArrayList<String> responses = new ArrayList<>();

        String msg = "";
        String response = "";

        File file = new File(systemProperties.get("programRootPath"));
        File[] fileList = file.listFiles();
        ArrayList<File> targets = new ArrayList<>();
        for (File f:fileList) {
            if (f.isFile() && f.getName().endsWith(".java")){
                targets.add(f);
            }
        }
        if (targets.isEmpty()){
            log.warn("Program root does not contain .java files");
            return;
        }

        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targets.size(); i++) {
            sb.append(IOUtils.readFile(targets.get(ptr++).getAbsolutePath()));
        }
        msg = PromptUtils.prompting(List.of(sb.toString()), PromptType.PLAIN_GET_CODE);

        response = multiAgentManager.chat(NAME, msg, responses, respPointer);


        ArrayList<ArrayList<String>> respss = new ArrayList<>();
        respss.add(MiscUtils.codeBlockFormatterList(response));

        for (int i = 0; i < 4; i++) {
            msg = PromptUtils.prompting(List.of(),PromptType.PLAIN_REFINE);
            response = multiAgentManager.chat(NAME,msg,responses,respPointer);
            respss.add(MiscUtils.codeBlockFormatterList(response));
        }

        cleanUp(systemProperties.get("GPTTestPath"),true);
        for (ArrayList<String> resps : respss) {
            for (String content : resps) {
                splitCode(content, systemProperties.get("GPTTestPath"));
            }
        }

        //5. output and cleanup
        multiAgentManager.closeAll();

        cleanUp(systemProperties.get("targetPath"),true);
        compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

        cleanUp(systemProperties.get("testPath"),true);
        compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

        JunitTester tester = new JunitTester(systemProperties);
        try{
            tester.launch();
        } catch (MalformedURLException ignored) {
        }

        cleanUp(systemProperties.get("targetPath"),true);
        cleanUp(systemProperties.get("testPath"),true);
//
        compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

        compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

        File tests = new File(systemProperties.get("testPath"));
        if (tests.listFiles().length<1){
            fail("Compile failed");
        }

        try{
            evaluationService.evaluateTest(202);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        log.info("Finish generation. Please check the test files at {}\n",systemProperties.get("GPTTestPath"));
        log.info("-----------------------------------------------");
        System.exit(0);

    }


    public String testPreprocess(TestClassFileBuilder builder) {
        builder.buildString();

        cleanUp(systemProperties.get("testPath"),true);
        Code cpResult = writeStringToJavaFile(builder.getResult(),systemProperties.get("GPTTestPath"),
                systemProperties.get("targetPath"),systemProperties.get("testPath"),systemProperties.get("libPath"),systemProperties);
        if (cpResult!=Code.SUCCESS){
            log.error("Compile failed.");
            return Code.EVALUATION_COMPILE_ERROR.name();
        }

        JunitTester tester = new JunitTester(systemProperties);
        String testLog = "";
        try{
            testLog = tester.launch();
        } catch (MalformedURLException e) {
            log.error("Error in JUnit Tester.",e);
        }
        return testLog;
    }

    private void CHECKERR(boolean err) throws RuntimeException {
        if (!err) {
            log.error("Error occurred.");
            throw new RuntimeException();
        }
    }

    private void loadSystemProperties() {
        log.info("Load path configuration......");
        for (String key : autogen.keySet()) {
            systemProperties.put(key,getPropertiesString(autogen,key));
        }
    }

}