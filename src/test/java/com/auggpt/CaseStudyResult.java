package com.auggpt;

import com.auggpt.service.CompileService;
import com.auggpt.service.EvaluationService;
import com.auggpt.service.FailRecordTestListener;
import com.auggpt.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.auggpt.utils.IOUtils.*;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class CaseStudyResult {
    private static final HashMap<String,String> systemProperties = new HashMap<>();
    private static ArrayList<String> GPTFailed = new ArrayList<>();
    private static ArrayList<String> HmFailed = new ArrayList<>();
    private static ArrayList<String> BothFailed = new ArrayList<>();
    private static ArrayList<String> BothPass = new ArrayList<>();

    /**
     * Uncommented to select. Can select multiple assignment. May take few minutes.
     */
    private static final String[] ASSIGNMENT_LIST = {
//                "calendar",
//                "treasure",
//                "chess",
//                "course",
                "shop",
//                "canvas"
    };


    private static long singleTime = 0;
    private static long estTime = 0;
    private static final double alpha = 0.25;
    private static final double beta = 6.0;
    private static final long magic = 5000;
    private static int tot = 0;
    private static int cur = 0;

    private static final Random rd = new Random();

    /**
     * <p> This will generate the raw result for case study in dataset/submissions/output
     * <p> May take a while.
     */
    @Test
    public void main() throws IOException {
        IOUtils.setLogging(false);
        CompileService.setLogging(false);

        loadPathProperties(systemProperties);
        initialize();

        File targetDir = new File("dataset/submissions");
        String targetRootPath = targetDir.getAbsolutePath();

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));

        for (String testSetName: ASSIGNMENT_LIST){
            systemProperties.put("programRootPath",targetRootPath+"/"+testSetName);
            Deque<File> stack = new ArrayDeque<>();

            GPTFailed = new ArrayList<>();
            HmFailed = new ArrayList<>();
            BothFailed = new ArrayList<>();
            BothPass = new ArrayList<>();

            singleTime = 0;
            estTime = 0;

            tot = 0;
            cur = 0;

            String GPTTestPath = "dataset/AugGPT_tests/"+testSetName;
            String HmTestPath = "dataset/human_tests/"+testSetName;

            stack.push(new File(systemProperties.get("programRootPath")));
            tot = 0;

            ArrayList<File> targetFiles = new ArrayList<>(100);
            while(!stack.isEmpty()){
                File file = stack.pop();
                if (file.isDirectory()){
                    File[] files = file.listFiles();
                    if (containJavaFile(files)){
                        targetFiles.add(file);
                        tot++;
                    }else {
                        for (File subfile:files)
                            stack.push(subfile);
                    }
                }
            }
            System.out.printf("Discover %d student submission.\r\n", tot);

            cur=0;
            stack.push(new File(systemProperties.get("programRootPath")));
            bar.createBar(tot,cur,'=');

            for (File file:targetFiles){
                systemProperties.put("programRootPath", file.getAbsolutePath());
                bar.printBar(tot,++cur);
                coreTest(GPTTestPath, HmTestPath, systemProperties);
            }

            String template = targetRootPath + "/output/" + now + "/" + testSetName;

            FileUtils.write(new File(template+"/GPTOut"),
                    GPTFailed.toString(), Charset.defaultCharset());
            FileUtils.write(new File(template+"/HmOut"),
                    HmFailed.toString());
            FileUtils.write(new File(template+"/BothFailed"),
                    BothFailed.toString());
            FileUtils.write(new File(template+"/BothPass"),
                    BothPass.toString());
        }
    }

    private static boolean containJavaFile(File[] files){
        for (File file:files){
            if (file.getName().contains(".java"))
                return true;
        }
        return false;
    }

    private static void coreTest(String GPTTestPath, String HmTestPath,
                                 HashMap<String, String> systemProperties) throws MalformedURLException {
        systemProperties.put("GPTTestPath", GPTTestPath);
        boolean isGPTFailed = true;
        long bef;
        long aft;

        try {
            isGPTFailed = !compileFiles(systemProperties);
        } catch (RuntimeException e) {
            System.out.println("GPT compile ERROR");
        }
        if (!isGPTFailed) {
            try {
                bef = System.currentTimeMillis();
                ComparativeTester GPTTester = new ComparativeTester(systemProperties);
                GPTTester.test();
                aft = System.currentTimeMillis();
                singleTime = (aft - bef);
                estTime = ((long) (magic + beta * alpha * singleTime + (1 - alpha) * estTime));
//            estTime = 8;

                isGPTFailed = GPTTester.containFailed();
            } catch (RuntimeException e) {
                System.out.println("ERROR");
            }
        }
        else {
            System.out.println("GPT compile ERROR");
        }


        systemProperties.put("GPTTestPath", HmTestPath);
        boolean isHmFailed = true;
        try {
            isHmFailed = !compileFiles(systemProperties);
        } catch (RuntimeException e) {
            System.out.println("Human compile ERROR");
        }
        if (!isHmFailed) {
            try {
                bef = System.currentTimeMillis();
                ComparativeTester HmTester = new ComparativeTester(systemProperties);
                HmTester.test();
                aft = System.currentTimeMillis();
                singleTime = (aft - bef);
                estTime = ((long) (magic + beta * alpha * singleTime + (1 - alpha) * estTime));
                isHmFailed = HmTester.containFailed();
            } catch (RuntimeException e) {
                System.out.println("ERROR");
            }
        }else {
            System.out.println("Human compile ERROR");
        }

        if (isGPTFailed && isHmFailed){
            BothFailed.add(systemProperties.get("programRootPath"));
        } else if (isGPTFailed && !isHmFailed) {
            GPTFailed.add(systemProperties.get("programRootPath"));
        } else if (!isGPTFailed && isHmFailed) {
            HmFailed.add(systemProperties.get("programRootPath"));
        } else if (!isGPTFailed && !isHmFailed) {
            BothPass.add(systemProperties.get("programRootPath"));
        }
    }

    private static boolean compileFiles(HashMap<String, String> systemProperties){
        cleanUp(systemProperties.get("targetPath"),true);
        cleanUp(systemProperties.get("testPath"),true);

        boolean pass = miniCompileService.compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

        if (!pass)
            return pass;

        pass = miniCompileService.compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

        return pass;
    }

    private static HashMap<String,String> loadPathProperties(HashMap<String,String> systemProperties) {
        ResourceBundle autogen = ResourceBundle.getBundle("auggpt", Locale.getDefault());
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



    static class bar{
        public static void printBar(int total, int now) {
            double percent = (now * 100.0) / total;
            int fillNum = (int) Math.round(percent);
            String bar = createBar(fillNum);
            System.out.printf("\rProgress [%s] %.2f%%", bar, percent);
            if (total == now) {
                System.out.println("\r\nDone!");
            }
        }
        private static String createBar(int fillNum) {
            return createBar(100, fillNum, '=');
        }
        public static String createBar(int total, int fillNum, char c) {
            char[] chars = new char[total];
            Arrays.fill(chars, 0, fillNum, c);
            Arrays.fill(chars, fillNum, total, ' ');
            return new String(chars);
        }
    }
    static class ComparativeTester {

        private final HashMap<String, FailRecordTestListener> listenerHashmap = new HashMap<>();
        private final ArrayList<String> testNames = new ArrayList<>();
        private final HashMap<String,String> systemProperties;

        public ComparativeTester(HashMap<String,String> systemProperties) {
            this.systemProperties = systemProperties;
        }

        /**
         * 测试在testPath下编译好的class文件，收集测试结果。
         * @throws MalformedURLException
         */
        public void test() throws MalformedURLException {

            String targetPath = systemProperties.get("targetPath");
            String testPath = systemProperties.get("testPath");

            HashMap<String,byte[]> testHashmap = IOUtils.getFileByte(testPath,".class");

            ArrayList<URL> urls = new ArrayList<>();
            urls = IOUtils.loadJarFiles(urls,new File(systemProperties.get("libPath")));
            urls.add(new File(systemProperties.get("libPath")+"/").toURI().toURL());
            urls.add(new File(targetPath+"/").toURI().toURL());
            urls.add(new File(testPath+"/").toURI().toURL());

            URLClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]));

            //设置搜索和过滤规则

            for (String testName : testHashmap.keySet()) {
                testNames.add(testName);
                listenerHashmap.put(testName,execute(classLoader,testName));
            }
        }

        private FailRecordTestListener execute(ClassLoader classLoader,String name) {
            failed = 0;
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(
                            selectClass(classLoader,name)
                    )
                    .build();

            Launcher launcher = LauncherFactory.create();
            FailRecordTestListener listener = new FailRecordTestListener();
            launcher.registerTestExecutionListeners(listener);

            Thread th = new Thread(() -> launcher.execute(request));

            th.start();
            try {
                th.join(Math.max(estTime,10000));
            } catch (InterruptedException e) {
                failed += 1;
                return listener;
            }

            return listener;
        }

        private double failed = 0;
        public boolean containFailed(){
            for (FailRecordTestListener listener:listenerHashmap.values()){
                failed += listener.getFailedRatio();
            }
            return failed != 0;
        }
    }

    static class miniCompileService {

        private static final Set<String> compileInformation = new HashSet<>();
        private static boolean first = false;


        /**
         *
         * A runtime compile method. If the first compilation failed, the method will try to get the failed lines commented,
         * and try again. Then, if it failed again, it will return the failure.
         * @param rootPath
         *      the target's root directory, used in classpath configuration
         * @param jarPath
         *      the third-party jar dependencies' directory
         * @param dest
         *      where the compiled class files are stored.
         * @param filePath
         *      if the path is to the file, then compile that file;<br>
         *      if the path is to the directory, then compile all the .java files in that directory.<br>
         *      must be the subdirectory of rootPath!
         * @param clean
         *      if true, it will delete the files that not named in target
         * @return
         *      whether compiled successfully.
         */
        public static boolean compile(String rootPath, String jarPath, String dest, String filePath,
                                      HashMap<String,String> systemProperties, boolean clean){
            String tempJavaFilePath = systemProperties.get("tempJavaFilePath");
            File file = new File(tempJavaFilePath);
            if (!file.exists()){
                file.mkdirs();
            }

            IOUtils.cleanUp(tempJavaFilePath,false);

            File target = new File(filePath);
            try{
                if (target.isDirectory())
                    FileUtils.copyDirectory(target, file);
                else
                    FileUtils.copyFileToDirectory(target, file);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            boolean success = compile(rootPath, jarPath, dest, tempJavaFilePath);

            if (clean && success){
                if (target.isDirectory())
                    deleteOtherFiles(target.list(), dest);
                else
                    deleteOtherFiles(new String[]{target.getName()}, dest);
            }

            return success;
        }

        public static boolean compile(String rootPath, String jarPath, String dest, String filePath, HashMap<String,String> systemProperties){
            return compile(rootPath, jarPath, dest, filePath, systemProperties, false);
        }


        public static boolean compile(String rootPath, String jarPath, String dest, String filePath){
            first = true;
            return compile(rootPath, jarPath, dest, filePath,0);
        }

        private static boolean compile(String rootPath, String jarPath, String dest, String filePath, Integer retry){

            Iterable<? extends JavaFileObject> files;
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            List<File> javaFiles = new ArrayList<>();
            File javaFile = new File(filePath);
            List<String> jars;

            //Do not want to dump all .class files into destination,
            //will extract the target file to dest later
            List<String> options = new ArrayList<>(Arrays.asList("-d", dest));


            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager =
                    compiler.getStandardFileManager(null, null, null);

            if (jarPath!=null){
                jars = classPathConfig(new ArrayList<>(Collections.singletonList(rootPath)),jarPath);
                options.addAll(jars);
            }

            if(javaFile.exists()){
                javaFiles.addAll(List.of(getFiles(javaFile.getAbsolutePath(), ".java")));
                files = fileManager.getJavaFileObjectsFromFiles(javaFiles);
            }else {
                return false;
            }

            JavaCompiler.CompilationTask task = compiler.getTask(
                    null, fileManager, diagnostics, options, null, files);
            Boolean result = task.call();

            if (result) {
            } else if (retry<6) {
                Map<Path, List<String>> sourceLinesMap = new HashMap<>();

                for (File sourceFile : javaFiles) {
                    try {
                        sourceLinesMap.put(sourceFile.toPath(), Files.readAllLines(sourceFile.toPath()));
                    } catch (IOException e) {
                    }
                }

                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    if (diagnostic.getKind() == Diagnostic.Kind.ERROR) {
                        JavaFileObject source = diagnostic.getSource();
                        if (source != null) {
                            Path sourcePath = Paths.get(source.toUri());
                            long lineNumber = diagnostic.getLineNumber();
                            String errorMessage = diagnostic.getMessage(Locale.ENGLISH);

                            if(first) {
                                String msg = diagnostic.getMessage(Locale.ENGLISH);
                                String[] msgs = msg.split("\n");
                                if (msgs.length>2){
                                    msg = msgs[0] + "\n" + msgs[1] + "\n";
                                }
                                compileInformation.add("ERROR: "+msg);
                                first = false;
                            }


                            List<String> sourceLines = sourceLinesMap.get(sourcePath);
                            int lineIndex = (int) lineNumber - 1;
                            if (lineIndex >= 0 && lineIndex < sourceLines.size()) {
                                sourceLines.set(lineIndex, "// ERROR: " + errorMessage.replace("\n","\n//") + "\n// " + sourceLines.get(lineIndex));
                            }
                        }
                    }
                }
                for (Map.Entry<Path, List<String>> entry : sourceLinesMap.entrySet()) {
                    try {
                        Files.write(entry.getKey(), entry.getValue());
                    } catch (IOException e) {
                    }
                }
                return compile(rootPath, jarPath, dest, filePath, ++retry);
            }
            return result;
        }


        /**
         * Automatically add the third-party jars in the specified path
         * to the classpath configuration.
         *
         * @param paths
         * @param jarPath
         * @return
         */
        private static List<String> classPathConfig(ArrayList<String> paths,String jarPath){
            File p = new File(jarPath);
            StringBuilder s = new StringBuilder();
            List<String> list = new ArrayList<>();
            list.add("-cp");

            Deque<File> stack = new ArrayDeque<>();
            if(p.exists()){
                File[] files = p.listFiles();
                for(File file:files){
                    if(file.isDirectory()){
                        stack.push(file);
                    }
                    else{
                        s.append(";").append(file.getAbsolutePath());
                    }
                }
                while(!stack.isEmpty()){
                    File fa = stack.pop();
                    File[] fa_ = fa.listFiles();
                    for (File sub:fa_){
                        if(sub.isDirectory()){
                            stack.push(sub);
                        }
                        else if(sub.getName().endsWith(".jar")){
                            s.append(";").append(sub.getAbsolutePath());
                        }
                    }
                }
            }
            paths.forEach(path -> s.append(";").append(path));
            s.append(";.;");
            list.add(s.toString());
            return list;
        }

    }
}


