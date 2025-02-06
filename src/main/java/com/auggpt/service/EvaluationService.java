package com.auggpt.service;

import com.auggpt.exception.MethodNotImplementException;
import com.auggpt.model.Code;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.auggpt.service.CoverageTester.covInfoFilter;
import static com.auggpt.utils.CommandLineUtils.run_cmd;
import static com.auggpt.service.CompileService.compile;
import static com.auggpt.utils.IOUtils.getClassesNames;
import static com.auggpt.utils.IOUtils.*;
import static com.auggpt.utils.MiscUtils.*;

@Slf4j
public class EvaluationService {
    private final static EvaluationService EVALUATION_SERVICE = new EvaluationService();
    private static HashMap<String,String> systemProperties;
    private static MutationTester mutationTester;
    private String nonCoverageInfo;

    // indicate whether the mutation test has been launched





    private EvaluationService(){
    }

    public static EvaluationService getInstance(HashMap<String,String> systemProperties){
        EvaluationService.systemProperties = systemProperties;
        mutationTester = new MutationTester(systemProperties);
        return EVALUATION_SERVICE;
    }

    public synchronized Code writeAndEvaluate(String raw, boolean isRaw){
        String code = isRaw? codeBlockFormatter(raw): raw;

        // Better not to reconstruct this method.
        Code cpResult = writeStringToJavaFile(code,systemProperties.get("GPTTestPath"),
                systemProperties.get("programRootPath"),systemProperties.get("testPath"),systemProperties.get("libPath"),systemProperties);
        log.info("Io and compile result: "+cpResult);

        if (!cpResult.equals(Code.SUCCESS)){
            return cpResult;
        }

        return evaluate();
    }

    public synchronized Code compileAndEvaluate(){
        if(compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                systemProperties.get("testPath"),systemProperties.get("GPTTestPath"))){
            return evaluate();
        }else {
            return Code.EVALUATION_COMPILE_ERROR;
        }
    }

    public synchronized Code evaluate() {
        try {
            evaluateTest(202);
        } catch (Exception e){
            log.error(e.getMessage());
            return Code.EVALUATION_ERROR;
        }
        try {
            //clean up to prepare for next round. If not, next evaluation will count the previous tests in.
            cleanUp(systemProperties.get("testPath"),true);
            return Code.SUCCESS;
        } catch (Exception e){
            log.error(e.getMessage());
            return Code.EVALUATION_ERROR;
        }
    }

    public synchronized String getNonCoveredInfo() {
        try {
            evaluateTest(102);

            return covInfoFilter(nonCoverageInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Double> getCoverageResults(){
        if(coverageTester.getResultMap()==null || coverageTester.getResultMap().isEmpty()){
            log.warn("Not perform coverage test yet!");
            return null;
        }
        return coverageTester.getResultMap();
    }

    private final CoverageTester coverageTester = new CoverageTester(System.out);

    /**
     *
     * @param type xyz
     *      <br>
     *      1yz: coverage test.<br>
     *      2yz: mutation test (Not implemented).<br>
     *      <br>
     *      y=0: baseline.<br>
     *      y=1: evosuite evaluation.<br>
     *      y=2: GPT evaluation.<br>
     * @throws Exception
     */
    public void evaluateTest(int type) throws Exception {
        switch (type){
            case 100:
                //coverage test baseline
                log.info("Running coverage test on test files at {}, the target file are at {}",
                        systemProperties.get("humanTestPath"),systemProperties.get("targetPath"));
                log.info("The result will be cloned as baseline.");

                coverageTester.execute(systemProperties, systemProperties.get("testPath"));
                Map<String, Double> coverageThresholds = coverageTester.cloneResultMap();

                log.info("The baseline is: {}", coverageThresholds);
                break;
            case 101:
                //coverage test evosuite
                log.info("Running coverage test on test files at {}, the target file are at {}",
                        systemProperties.get("testPath"),systemProperties.get("targetPath"));
                coverageTester.execute(systemProperties, systemProperties.get("testPath"));
                log.info("The test result is: {}",coverageTester.getResultMap());
                break;
            case 102:
                //coverage test gpt
                log.info("Running coverage test on test files at {}, the target file are at {}",
                        systemProperties.get("GPTTestPath"),systemProperties.get("targetPath"));
                nonCoverageInfo = coverageTester.execute(systemProperties, systemProperties.get("testPath"));
                log.info("The test result is: {}",coverageTester.getResultMap());
                break;
            case 200:
                //coverage test baseline
                log.info("Running mutation test on test files at {}, the target file are at {}",
                        systemProperties.get("humanTestPath"),systemProperties.get("targetPath"));
                log.info("The result will be cloned as baseline.");

                mutationTester.evaluateTestMutation(systemProperties, systemProperties.get("testPath"));
                Map<String, Double> mutationThresholds = cloneHashMap(mutationTester.mutationResults);

                log.info("The baseline is: {}", mutationThresholds);
                break;
            case 202:
                //coverage test gpt
                log.info("Running mutation test on test files at {}, the target file are at {}",
                        systemProperties.get("testPath"),systemProperties.get("targetPath"));
                mutationTester.evaluateTestMutation(systemProperties, systemProperties.get("testPath"));
                break;
            default:
                throw new MethodNotImplementException();
        }
    }

    public static Map<String, Double> getMutationResults() {
        return mutationTester.mutationResults;
    }


    public static final String PIT_RAW_SCRIPT = "@echo off\n" +
            "echo command:\n" +
            "echo java -cp PIT_LIB;TARGET_PATH;TEST_PATH;\n" +
            "echo         org.pitest.mutationtest.commandline.MutationCoverageReport \\\n" +
            "echo         --reportDir REPORT_DIR\n" +
            "echo         --targetClasses TARGETS\n" +
            "echo         --targetTests com.your.package.*\n" +
            "echo         --sourceDirs SRC_DIR\n" +
            "echo         --mutableCodePaths TARGET_PATH\n" +
            "echo         --targetTests TESTS\n" +
            "echo         --outputEncoding UTF-8\n" +
            "echo running...\n" +
            "\n" +
            "cd PIT_PATH\n" +
            "\n" +
            "%JAVA_HOME%/bin/java.exe -version\n" +
            "\n" +
            "%JAVA_HOME%/bin/java.exe -cp PIT_LIB;TARGET_PATH;TEST_PATH; org.pitest.mutationtest.commandline.MutationCoverageReport --reportDir REPORT_DIR --sourceDirs SRC_DIR --targetClasses TARGETS --mutableCodePaths TARGET_PATH --targetTests TESTS --outputEncoding UTF-8 --verbose --threads 2\n" +
            "\n" +
            "echo done\n";

    public Map<String, ArrayList<String>> getMutationInfo() {
        return mutationTester.getMutationInfo();
    }
}
