package com.auggpt;


import com.auggpt.model.CoverageMetrics;
import com.auggpt.service.EvaluationService;
import com.auggpt.service.JunitTester;
import com.auggpt.utils.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.auggpt.service.CompileService.compile;
import static com.auggpt.utils.IOUtils.cleanUp;
import static com.auggpt.utils.IOUtils.getPropertiesString;
import static org.junit.jupiter.api.Assertions.fail;


public class EfficiencyTest {
    private static ResourceBundle autogen;
    private static HashMap<String,String> systemProperties = new HashMap<>();
    private static EvaluationService evaluationService;

    /**
     * Uncommented to select. Can select multiple assignment, but the result may be too much to check.
     */
    private static final String[] ASSIGNMENT_LIST = {
            "calendar",
            "treasure",
            "course",
            "canvas",
            "shop",
            "chess",
    };

    /**
     * Uncommented to select. Can select multiple test set, but the result may be too much to check.
     */
    private static final String[] TEST_SET_LIST = {
            "human_tests",
            "plain_tests",
            "AugGPT_tests",
            "human_and_plain_tests",
            "human_and_AugGPT_tests"
    };

    @BeforeEach
    public void init() {
        loadPathProperties(systemProperties);
        evaluationService = EvaluationService.getInstance(systemProperties);
        initialize();
    }

    /**
     * Run this test to generate mutation test result.
     * @throws Exception
     */
    @Test
    public void mutationTest() throws Exception {
        String datasetPath = "dataset";

        for (String assignmentName: ASSIGNMENT_LIST){
            for (String testSetName: TEST_SET_LIST){
                String testSetPath = datasetPath+"/"+testSetName+"/"+assignmentName;
                String srcProgramPath = datasetPath+"/standard_answer/"+assignmentName;

                systemProperties.put("GPTTestPath", testSetPath);
                systemProperties.put("programRootPath", srcProgramPath);

                cleanUp(systemProperties.get("targetPath"),true);
                cleanUp(systemProperties.get("testPath"),true);

                compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                        systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

                compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                        systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

                File tests = new File(systemProperties.get("testPath"));
                if (tests.listFiles().length<1){
                    fail("Compile failed");
                }


                evaluationService.evaluateTest(202);
            }
        }
    }

    /**
     * Run this test to generate mutation test result.
     * @throws Exception
     */
    @Test
    public void covTest() throws Exception {
        String datasetPath = "dataset";

        BufferedWriter bw = new BufferedWriter(new FileWriter("log/coverage_result"));

        for (String assignmentName: ASSIGNMENT_LIST){
            for (String testSetName: TEST_SET_LIST){

                String testSetPath = datasetPath+"/"+testSetName+"/"+assignmentName;
                String srcProgramPath = datasetPath+"/standard_answer/"+assignmentName;

                systemProperties.put("GPTTestPath", testSetPath);
                systemProperties.put("programRootPath", srcProgramPath);

                cleanUp(systemProperties.get("targetPath"),true);
                cleanUp(systemProperties.get("testPath"),true);

                compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                        systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

                compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                        systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

                File tests = new File(systemProperties.get("testPath"));
                if (tests.listFiles().length<1){
                    fail("Compile failed");
                }

                evaluationService.evaluateTest(101);


                bw.write(String.format("---------- %s: %s -----------\n",assignmentName,testSetName));

                HashMap<String,Double> resultMap = evaluationService.getCoverageResults();
                double resultIns = resultMap.get(CoverageMetrics.INSTRUCTION.name());
                double resultBranches = resultMap.get(CoverageMetrics.BRANCH.name());

                bw.write(String.format("%.5f %s covered%n", 1-resultIns,"instructions"));
//                bw.write(String.format("%.5f %s missed%n", resultIns,"instructions"));
                bw.write(String.format("%.5f %s covered%n", 1-resultBranches,"branches"));
//                bw.write(String.format("%.5f %s missed%n", resultBranches,"branches"));
                bw.write("------------------------------------\n\n");
            }
        }
        bw.close();
    }

    private static HashMap<String,String> loadPathProperties(HashMap<String,String> systemProperties) {
        autogen = ResourceBundle.getBundle("auggpt", Locale.getDefault());
        for (String key : autogen.keySet()) {
            systemProperties.put(key,getPropertiesString(autogen,key));
        }
        return systemProperties;
    }

    private static void initialize() {
        File dir = new File(systemProperties.get("rootPath"));
        if (!dir.exists()){
            System.out.println("data directory does not exist, creating");
            dir.mkdirs();
        }

        dir = new File(systemProperties.get("libPath"));
        if (!dir.exists()){
            System.out.println("lib directory not exist, creating");
            dir.mkdirs();
        }

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files==null || files.length==0){
                System.exit(1);
            }
        }

        dir = new File(systemProperties.get("corePath"));
        if (!dir.exists()){
            System.out.println("script directory does not exist, creating");
            dir.mkdirs();
        }
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files==null || files.length==0){
                System.out.println("script directory is empty, creating script file");
                File pitScript = new File(systemProperties.get("corePath")+"\\\\PIT_script_raw.bat");
                IOUtils.writeFile(pitScript.getAbsolutePath(), EvaluationService.PIT_RAW_SCRIPT);
            }
        }


        dir = new File(systemProperties.get("targetPath"));
        if (!dir.exists()){
            System.out.println("Target directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("testPath"));
        if (!dir.exists()){
            System.out.println("Test directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("GPTTestPath"));
        if (!dir.exists()){
            System.out.println("System output directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("PITReportPath"));
        if (!dir.exists()){
            System.out.println("PITest report output directory does not exist, creating");
            dir.mkdirs();
        }
        dir = new File(systemProperties.get("tempJavaFilePath"));
        if (!dir.exists()){
            System.out.println("Temp directory does not exist, creating");
            dir.mkdirs();
        }

        System.out.println("Initialization finish");
    }
}
