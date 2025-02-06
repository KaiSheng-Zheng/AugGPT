package com.auggpt;


import com.auggpt.service.EvaluationService;
import com.auggpt.service.JunitTester;
import com.auggpt.utils.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.auggpt.service.CompileService.compile;
import static com.auggpt.utils.IOUtils.cleanUp;
import static com.auggpt.utils.IOUtils.getPropertiesString;
import static org.junit.jupiter.api.Assertions.fail;


public class GeneralTest {
    private static ResourceBundle autogen;
    private static HashMap<String,String> systemProperties = new HashMap<>();
    private static EvaluationService evaluationService;

    @BeforeEach
    public void init() {
        loadPathProperties(systemProperties);
        evaluationService = EvaluationService.getInstance(systemProperties);
        initialize();
    }

    /**
     * Run this test to run mutation test on the test under data/GPTTests directory
     * @throws Exception
     */
    @Test
    public void mutationTest() throws Exception {
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
