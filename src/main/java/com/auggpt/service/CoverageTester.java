
package com.auggpt.service;

import com.auggpt.model.CoverageMetrics;
import com.auggpt.utils.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.jacoco.core.analysis.*;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.IRuntime;
import org.jacoco.core.runtime.LoggerRuntime;
import org.jacoco.core.runtime.RuntimeData;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.utils.MiscUtils.cloneHashMap;
import static com.auggpt.utils.TestClassFileBuilder.methodPattern;



@Slf4j
public final class CoverageTester {

    private final PrintStream out;
    private final HashMap<String,Double> resultMap;
    private String nonCoverageInfo;
    private boolean logging = true;

    /**
     * Creates a new example instance printing to the given stream.
     *
     * @param out
     *            stream for outputs
     *
     */
    public CoverageTester(final PrintStream out) {
        this.out = out;
        this.resultMap = new HashMap<>();
    }
    public CoverageTester(final PrintStream out, boolean logging) {
        this(out);
        this.logging = logging;
    }



    public String execute(HashMap<String,String> systemProperties,String testPath) throws Exception {
        String targetPath = systemProperties.get("targetPath");
        String rootPath = systemProperties.get("rootPath");

        String tempInstrTargetPath = rootPath + "\\temp\\targets\\instr";
        String tempInstrTestPath = rootPath + "\\temp\\tests\\instr";

        HashMap<String,byte[]> testHashmap = IOUtils.getFileByte(testPath,".class");
        HashMap<String,byte[]> targetHashmap = IOUtils.getFileByte(targetPath,".class");

        final IRuntime runtime = new LoggerRuntime();

        final Instrumenter instr = new Instrumenter(runtime);

        File tempTargetFile = new File(tempInstrTargetPath);
        File tempTestFile = new File(tempInstrTestPath);
        boolean err;
        if (!tempTargetFile.exists()){
            err = tempTargetFile.mkdirs();
        }
        if (!tempTestFile.exists()){
            err = tempTestFile.mkdirs();
        }

        for(String className:targetHashmap.keySet()){
            byte[] instrTemp = instr.instrument(targetHashmap.get(className),className);
            IOUtils.writeByte(instrTemp,tempTargetFile.getAbsolutePath()+"/"+className+".class");
        }
        for(String className:testHashmap.keySet()){
            byte[] instrTemp = instr.instrument(testHashmap.get(className),className);
            IOUtils.writeByte(instrTemp,tempTestFile.getAbsolutePath()+"/"+className+".class");
        }

        final RuntimeData data = new RuntimeData();
        runtime.startup(data);

        ArrayList<URL> urls = new ArrayList<>();
        urls = IOUtils.loadJarFiles(urls,new File(systemProperties.get("libPath")));
        urls.add(new File(tempTestFile.getAbsolutePath()+"/").toURI().toURL());
        urls.add(new File(tempTargetFile.getAbsolutePath()+"/").toURI().toURL());

        URLClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]));

        // Here we execute our test target class by reflection, which should be instrumented:
        for(String className:targetHashmap.keySet()){
            Class<?> target = classLoader.loadClass(className);
        }
        for(String className:testHashmap.keySet()){
            Class<?> test = classLoader.loadClass(className);
            if(className.contains("scaffolding")){
                continue;
            }

            Constructor<?> con = test.getDeclaredConstructor();
            con.setAccessible(true);
            Object testO = con.newInstance();

            Method[] testMethods = test.getDeclaredMethods();

            //Try to sort by name
            Arrays.sort(testMethods, Comparator.comparing(Method::getName));

            ArrayList<Method> beforeMethods = new ArrayList<>();
            ArrayList<Method> afterMethods = new ArrayList<>();
            ArrayList<Method> normalTestMethods = new ArrayList<>();
            for(Method mo:testMethods){
                if(Arrays.stream(mo.getDeclaredAnnotations()).anyMatch(annotation -> annotation.toString().contains("Before"))){
                    beforeMethods.add(mo);
                }
                else if(Arrays.stream(mo.getDeclaredAnnotations()).anyMatch(annotation -> annotation.toString().contains("After"))){
                    afterMethods.add(mo);
                }
                else if(Arrays.stream(mo.getDeclaredAnnotations()).anyMatch(annotation -> annotation.toString().contains("Test"))){
                    normalTestMethods.add(mo);
                }
            }

            for(Method mo:normalTestMethods){
                try {
                    for(Method bef:beforeMethods){
                        bef.setAccessible(true);
                        bef.invoke(testO);
                    }
                    mo.setAccessible(true);
                    mo.invoke(testO);
                    for(Method aft:afterMethods){
                        aft.setAccessible(true);
                        aft.invoke(testO);
                    }
                } catch (Exception e){
                    log.warn("Test case "+mo.getName()+" failed.",e);
                }
            }
        }

        // At the end of test execution we collect execution data and shutdown
        // the runtime:
        final ExecutionDataStore executionData = new ExecutionDataStore();
        final SessionInfoStore sessionInfos = new SessionInfoStore();
        data.collect(executionData, sessionInfos, false);
        runtime.shutdown();

        // Together with the original class definition we can calculate coverage
        // information:
        final CoverageBuilder coverageBuilder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(executionData, coverageBuilder);

        for(String className:targetHashmap.keySet()){
            analyzer.analyzeClass(targetHashmap.get(className),className);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Coverage information:\n");

        int missedIns = 0;
        int totalIns = 0;

        int missedBranches = 0;
        int totalBranches = 0;

        for (final IClassCoverage cc : coverageBuilder.getClasses()) {
            List<String> fileLines = Files.readAllLines(Path.of(systemProperties.get("programRootPath") + "\\\\" + cc.getSourceFileName()));

            missedIns += cc.getInstructionCounter().getMissedCount();
            totalIns += cc.getInstructionCounter().getTotalCount();

            missedBranches += cc.getBranchCounter().getMissedCount();
            totalBranches += cc.getBranchCounter().getTotalCount();

            boolean allGreen = true;
            HashMap<IMethodCoverage, Boolean> redMethods = new HashMap<>();
            for (IMethodCoverage method : cc.getMethods()) {
                boolean isRed = false;
                for (int i = method.getFirstLine(); i <= method.getLastLine(); i++){
                    if (method.getLine(i).getStatus() == ICounter.NOT_COVERED || method.getLine(i).getStatus() == ICounter.PARTLY_COVERED){
                        isRed = true;
                        allGreen = false;
                        break;
                    }
                }
                redMethods.put(method,isRed);
            }
            if (allGreen){
                continue;
            }else {
                sb.append("Class: ").append(cc.getName()).append("\n");
            }

            int firstLine = cc.getFirstLine();
            int lastLine = cc.getLastLine();

            Pattern pat = Pattern.compile(methodPattern);
            Matcher mat = pat.matcher(String.join("\n",fileLines));
            StringBuilder tmpsb = new StringBuilder();

            while(mat.find()) {
                String methodName = mat.group(3);
                if(methodName.equals("for") || methodName.equals("while") || methodName.equals("do")){

                } else {
                    mat.appendReplacement(tmpsb,mat.group().replace(methodName, " "));
                }

            }
            mat.appendTail(tmpsb);
            fileLines = List.of(tmpsb.toString().split("\n"));

            int linePtr = 0;
            for (; linePtr < firstLine-1; linePtr++) {
                String line = fileLines.get(linePtr);
                if (line.isBlank()){
                    continue;
                }
                sb.append(line).append("\n");
            }


            for (; linePtr < lastLine; linePtr++) {
                String line = fileLines.get(linePtr);

                if (line.isBlank()){
                    continue;
                }
                sb.append(String.format("%s %s\n",getColor(cc.getLine(linePtr+1).getStatus()),line));
            }
            for (; linePtr < fileLines.size(); linePtr++) {
                String line = fileLines.get(linePtr);
                if (line.isBlank()){
                    continue;
                }
                sb.append(line).append("\n");
            }

        }

        if(logging){
            log.info("--------------");
            log.info("Coverage Result:");
            for(String type:resultMap.keySet()){
                log.info(String.format("%s: %.3f%n",type,1-resultMap.get(type)));
            }
        }

        IOUtils.cleanUp(tempInstrTestPath,false);
        IOUtils.cleanUp(tempInstrTargetPath,false);

        nonCoverageInfo = sb.toString();

        double resultIns = (double) missedIns /(double) totalIns;
        double resultBranches = (double) missedBranches /(double) totalBranches;
        resultMap.put(CoverageMetrics.INSTRUCTION.name(), resultIns);
        resultMap.put(CoverageMetrics.BRANCH.name(), resultBranches);

        if (logging) {
            out.printf("%.5f %s missed%n", resultIns,"instructions");
            out.printf("%.5f %s missed%n", resultBranches,"branches");
        }

        return nonCoverageInfo;
    }


    private void printCounter(final String unit, final ICounter counter, HashMap<String,Double> resultMap) {
        final Integer missed = Integer.valueOf(counter.getMissedCount());
        final Integer total = Integer.valueOf(counter.getTotalCount());
        if (logging) out.printf("%.2f %s missed%n", (float)missed/total,unit);
        if(total.equals(0)){
            return;
        }
        if(resultMap.containsKey(unit)){
            resultMap.put(unit,resultMap.get(unit)+missed.doubleValue()/total.doubleValue());
        }else {
            resultMap.put(unit, missed.doubleValue()/total.doubleValue());
        }
    }

    private String getColor(final int status) {
        switch (status) {
            case ICounter.NOT_COVERED:
                return "NOT_COVERED:";
            case ICounter.PARTLY_COVERED:
                return "PARTLY_COVERED:";
            case ICounter.FULLY_COVERED:
                return "FULLY_COVERED:";
            default:
                return "";
        }
    }

    /**
     * Creates a new example instance printing to the given stream.
     * @return
     *      execute result dictionary, contains:
     *      "instructions","branches","lines","methods","complexity"
     *
     */
    public HashMap<String, Double> getResultMap() {
        if(resultMap.isEmpty()){
            log.warn("The result dictionary is empty, may not execute yet!");
        }
        return resultMap;
    }

    public Map<String, Double> cloneResultMap() {
        if(resultMap.isEmpty()){
            log.warn("The result dictionary is empty, may not execute yet!");
        }
        return cloneHashMap(resultMap);
    }



    public static String covInfoFilter(String input) {

        try (BufferedReader reader = new BufferedReader(new StringReader(input))){

            String line;
            Stack<String[]> stack = new Stack<>();
            int lineNum = 0;

            ArrayList<String> content = new ArrayList<>();
            boolean isNonCov = false;

            while((line=reader.readLine()) != null){
                content.add(line);
                lineNum++;
                int matchNum = getOccur(line, "{")-getOccur(line, "}");

                if (line.contains("NOT_COVERED") || line.contains("PARTLY_COVERED")){
                    isNonCov = true;
                }

                if(matchNum > 0){
                    for(int i=0;i<matchNum;i++){
                        stack.push(new String[]{line, lineNum+""});
                    }
                }else{
                    for(int i=0;i<-matchNum;i++){
                        String[] popArr = stack.pop();
                        if(stack.size()==1){
                            int beginNum = Integer.parseInt(popArr[1]);
                            int methodLineLen = lineNum-beginNum;
                            if (!isNonCov) {
                                for (int j = 0; j < methodLineLen; j++) {
                                    content.remove(content.size()-1);
                                }
                            }
                            isNonCov = false;
                        }
                    }
                }
            }
            return String.join("\n",content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static int getOccur(String src, String find) {
        int o = 0;
        int index = -1;
        while ((index = src.indexOf(find, index)) > -1) {
            ++index;
            ++o;
        }
        return o;
    }
}