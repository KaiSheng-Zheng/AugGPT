package com.auggpt.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.auggpt.utils.IOUtils;
import lombok.extern.slf4j.Slf4j;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.auggpt.utils.IOUtils.deleteOtherFiles;

@Slf4j
public class CompileService {

    private static final Set<String> compileInformation = new HashSet<>();
    private static boolean first = false;

    public static void setLogging(boolean logging) {
        CompileService.logging = logging;
    }

    private static boolean logging = true;


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
                org.apache.commons.io.FileUtils.copyDirectory(target, file);
            else
                org.apache.commons.io.FileUtils.copyFileToDirectory(target, file);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
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

        if (logging) log.info("Compiling {}...", filePath);

        Iterable<? extends JavaFileObject> files;
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        List<File> javaFiles = null;
        File javaFile = new File(filePath);
        List<String> jars;

        //Do not want to dump all .class files into destination,
        //will copy the compiled target file to dest later
        List<String> options = new ArrayList<>(Arrays.asList("-d", dest));


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);

        if (jarPath!=null){
            if (logging) log.info("Adding third-party jar dependencies' in directory: {}", jarPath);
            jars = classPathConfig(new ArrayList<>(Collections.singletonList(rootPath)),jarPath);
            options.addAll(jars);
        }

        if(javaFile.exists()){
            javaFiles = List.of(IOUtils.getFiles(javaFile.getAbsolutePath(), ".java"));
            files = fileManager.getJavaFileObjectsFromFiles(javaFiles);
        }else {
            return false;
        }

        JavaCompiler.CompilationTask task = compiler.getTask(
                null, fileManager, diagnostics, options, null, files);
        Boolean result = task.call();

        if (result) {
            if (logging) log.info("Compile {} successfully", filePath);
        } else if (retry<6) {
            Map<Path, List<String>> sourceLinesMap = new HashMap<>();

            for (File sourceFile : javaFiles) {
                try {
                    sourceLinesMap.put(sourceFile.toPath(), Files.readAllLines(sourceFile.toPath()));
                } catch (IOException e) {
                    if (logging) log.error("Write error in compiler", e);
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
                    if (logging) log.error("Write error in compiler",e);
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

    public static String getCompileInfoString(){
        return JSON.toJSONString(compileInformation.toString(), SerializerFeature.PrettyFormat);
    }
}
