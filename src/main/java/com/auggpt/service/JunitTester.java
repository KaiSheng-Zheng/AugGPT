package com.auggpt.service;

import com.alibaba.fastjson.JSON;
import com.auggpt.utils.IOUtils;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.utils.IOUtils.writeStringToJavaFile;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

public class JunitTester {

    private HashMap<String, FailRecordTestListener> listenerHashmap = new HashMap<>();
    private ArrayList<String> testNames = new ArrayList<>();
    private HashMap<String,String> systemProperties;

    public JunitTester(HashMap<String,String> systemProperties) {
        this.systemProperties = systemProperties;
    }


    public String launch() throws MalformedURLException {
        test();
        modify();
        return getTestFailedLog();
    }


    public void test() throws MalformedURLException {

        String targetPath = systemProperties.get("targetPath");
        String testPath = systemProperties.get("testPath");

        HashMap<String,byte[]> testHashmap = IOUtils.getFileByte(testPath,".class");
        HashMap<String,byte[]> targetHashmap = IOUtils.getFileByte(targetPath,".class");

        ArrayList<URL> urls = new ArrayList<>();
        urls = IOUtils.loadJarFiles(urls,new File(systemProperties.get("libPath")));
        urls.add(new File(systemProperties.get("libPath")+"/").toURI().toURL());
        urls.add(new File(targetPath+"/").toURI().toURL());
        urls.add(new File(testPath+"/").toURI().toURL());

        URLClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]));

        for (String testName : testHashmap.keySet()) {
            testNames.add(testName);
            listenerHashmap.put(testName,execute(classLoader,testName));
        }
    }

    private String getTestFailedLog() {
        HashMap<String,String> logMap = new HashMap<>();
        for (String tst: listenerHashmap.keySet()){
            logMap.put(tst, listenerHashmap.get(tst).getTestFailedReasonHashMap().toString());
        }
        return JSON.toJSONString(logMap);
    }

    /**
     * <p> Insert @Disabled annotation on failed tests. This will overwrite the original file!
     */
    private void modify(){
        String testPath = systemProperties.get("GPTTestPath");
//        StringBuilder builder;

        for (String testName: testNames){
            FailRecordTestListener listener = listenerHashmap.get(testName);

            String testFilePath = testPath+"/"+testName+".java";
            String testFile = IOUtils.readFile(testFilePath);
//            builder = new StringBuilder(testFile);

            ArrayList<String> failedNames = listener.getFailedName();
            if (failedNames.isEmpty())
                continue;
            StringBuilder patSb = new StringBuilder();
            String testmethod = "@Test\\s*(public )?void ";



            for (String failedName: failedNames) {
                patSb.append("(").append(testmethod).append(failedName).append(")|");
            }

            patSb.deleteCharAt(patSb.length()-1);

            Pattern pat = Pattern.compile(patSb.toString());
            Matcher matcher = pat.matcher(testFile);
            StringBuilder result = new StringBuilder();

            while(matcher.find()){
                matcher.appendReplacement(result,"//"+matcher.group());
            }
            matcher.appendTail(result);

            IOUtils.writeFile(testFilePath,result.toString());
        }
    }

    private FailRecordTestListener execute(ClassLoader classLoader,String name) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(classLoader,name)
                )
                .build();

        Launcher launcher = LauncherFactory.create();

        FailRecordTestListener listener = new FailRecordTestListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        return listener;
    }

    public boolean containFailed(){
        double failed = 0;
        for (FailRecordTestListener listener:listenerHashmap.values()){
            failed += listener.getFailedRatio();
        }
        return failed != 0;
    }
}
