package com.auggpt.utils;

import com.auggpt.model.Code;
import com.auggpt.model.Ignore;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.service.CompileService.compile;

@Slf4j
public class IOUtils {

    public static void setLogging(boolean logging) {
        IOUtils.logging = logging;
    }

    private static boolean logging = true;

    /**
     *
     * @param test
     *      The string content of test file.
     * @param path
     *      The output path of test file.
     * @return
     * @throws IOException
     */
    public static Code writeStringToJavaFile(String test, String path) throws IOException {
        if(writeStringToJavaFile(test, path, null)!=null){
            return Code.SUCCESS;
        }else{
            return Code.EVALUATION_IO_WRITING_ERROR;
        }
    }

    public static Code writeStringToJavaFile(String test, String path, String programRootPath,
                                             String compileDest, String compileLib, HashMap<String,String> systemProperties) {

        File javaFile = writeStringToJavaFile(test, path, null);
        if(javaFile==null){
            return Code.EVALUATION_IO_WRITING_ERROR;
        }

        if (compile(programRootPath,
                compileLib,
                compileDest,
                javaFile.getAbsolutePath(),systemProperties)
        ){
            return Code.SUCCESS;
        }else {
            return Code.EVALUATION_COMPILE_ERROR;
        }

    }
    private static File writeStringToJavaFile(String content, String path, Ignore ignore){
        FileOutputStream fos;
        OutputStreamWriter osw = null;

        try {
            File file = new File(path);
            File javaFile = file;
            String className = null;
            if(file.exists()&&file.isDirectory()){
                int classNameIdx0 = content.indexOf("class ");
                int classNameIdx1 = content.indexOf("{");
                className = content.substring(classNameIdx0 + 6, classNameIdx1-1);
                javaFile = new File(path+"\\"+className+".java");
                fos = new FileOutputStream(javaFile);
            }
            else fos = new FileOutputStream(file);

            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(content);
            osw.flush();
            if(logging) log.info("Test file written to {}", javaFile.getAbsolutePath());
            osw.close();
            return javaFile;
        } catch (IOException e) {
            log.error("Compile error: ",e);
            return null;
        }
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine())!=null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static HashMap<String,String> readFiles(File[] files) {
        StringBuilder content = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();

        for(File file:files){
            try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine())!=null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(file.getName(),content.toString());
            content = new StringBuilder();
        }
        return map;
    }

    /**
     * Will overwrite
     * @param filePath
     * @param content
     * @return
     */
    public static Code writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return Code.SUCCESS;
        } catch (IOException ioe) {
            log.info(ioe.getMessage());
            return Code.EVALUATION_IO_WRITING_ERROR;
        }
    }
    public static String getFileName(String filePath){
        return filePath.substring(filePath.lastIndexOf(File.separator)+1);
    }


    public static Pattern keyMatchLimitCount = Pattern.compile("@([a-zA-Z_]+)");

    /**
     * A convenient getString() extension with "@param" substitution function.
     * @param resource
     * @param k
     * @return
     */
    public static String getPropertiesString(ResourceBundle resource, String k){
        String v = resource.getString(k);
        boolean find = true;
        while(find){
            find = false;
            Matcher m = keyMatchLimitCount.matcher(v);
            while (m.find()) {
                find = true;
//            String param = m.group(1);
//                log.info(m.group(1));
                v = m.replaceAll(resource
                        .getString(m.group(1))
                        .replace("\\","\\\\"));
            }
        }

        return v;
    }

    public static File[] getFiles(String path, String type) {
        ArrayList<File> files = new ArrayList<>();
        Deque<File> stack = new ArrayDeque<>();

        stack.push(new File(path));
        while(!stack.isEmpty()){
            File file = stack.pop();
            if (file.exists() && file.isDirectory()){
                File[] subdirs = file.listFiles(File::isDirectory);
                if (subdirs!=null)stack.addAll(List.of(subdirs));

                File[] subfiles = file.listFiles(pathname -> pathname.getName().endsWith(type));
                if (subfiles!=null)files.addAll(List.of(subfiles));

            } else if(file.exists() && file.getName().endsWith(type)){
                files.add(file);
            }
        }

        return files.toArray(new File[0]);
    }

    public static File[] getClassesFiles(String clazzPathStr){
        return getFiles(clazzPathStr,".class");
    }

    public static String[] getClassesNames(String clazzPathStr){
        File[] files = getClassesFiles(clazzPathStr);
        return getClassesNames(files);
    }

    public static String[] getClassesNames(File[] files){
        String[] s = null;
        if (files != null) {
            s = new String[files.length];
            for (int i = 0; i< files.length;i++) {
                File file = files[i];
                String t = file.getName();
                s[i] = t.substring(0, t.length() - 6);
            }
        }

        return s;
    }

    public static byte[] getFileByte(File file){
        if(file.exists()){
            byte[] bytes = new byte[0];
            try {
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int len;
                byte[] buffer = new byte[1024];
                while ((len = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                bytes = baos.toByteArray();
                fis.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(logging) log.info(String.format("Load file %s as byte array success",file.getName()));
            return bytes;
        }else{
            return null;
        }
    }

    /**
     * Load all files as bytes into a hashmap.
     * @param rootPath
     *      The class path.
     * @param postfix
     *      e.g., ".class", ".java", ".txt"
     *
     * @return
     *       A hashmap of file name and its byte array.
     */
    public static HashMap<String,byte[]> getFileByte(String rootPath, String postfix){
        File rootPath_ = new File(rootPath);
        HashMap<String, byte[]> fileByteMap = new HashMap<>();
        Deque<File> stack = new ArrayDeque<>();
        stack.push(rootPath_);

        if(rootPath_.exists() && rootPath_.isDirectory()){
            while(!stack.isEmpty()){
                rootPath_ = stack.pop();
                int rootPathLen = rootPath_.getAbsolutePath().length() + 1;
                File[] files = rootPath_.listFiles(pathname -> {
                    return pathname.isDirectory() || pathname.getName().endsWith(postfix);
                });
                if(files ==null)
                    return fileByteMap;

                for(File file : files){
                    if(file.isDirectory()){
                        stack.push(file);
                        continue;
                    }
                    String rawName = file.getAbsolutePath();
                    String filename = rawName.substring(rootPathLen, rawName.length() - postfix.length());
                    filename = filename.replace(File.separatorChar, '.');

                    byte[] bytes = getFileByte(file);

                    fileByteMap.put(filename,bytes);
                }
            }
        }
        return fileByteMap;
    }

    public static ArrayList<URL> loadJarFiles(ArrayList<URL> urls, File file) throws MalformedURLException {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    loadJarFiles(urls,subFile);
                }
            }
        } else {
            if (file.getAbsolutePath().endsWith(".jar")) {
                urls.add(file.toURI().toURL());
            }
        }
        return urls;
    }

    public static void writeByte(byte[] bytes, String path) {
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A simple method to remove all sub files under a directory.
     * @param path
     *      The path to a directory. If it is a file, it will be deleted directly.
     * @param all
     *      If true, all files and sub-directories will be deleted.
     *      If false, only the files under the directory will be deleted.
     */
    public static void cleanUp(String path,boolean all) {
        if (logging) log.info("Delete files under {}",path);
        File file = new File(path);
        if(file.isFile()){
            file.delete();
            return;
        }
        for(File subFile : Objects.requireNonNull(file.listFiles())){
            if(subFile.isDirectory()) {
                cleanUp(subFile.getAbsolutePath(), all);
                if(all){
                    subFile.delete();
                }
            }else{
                subFile.delete();
            }
        }
    }

    public static void deleteOtherFiles(String[] javaFiles, String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        String[] classFilesToKeep = new String[javaFiles.length];
        for (int i = 0; i < javaFiles.length; i++) {
            classFilesToKeep[i] = javaFiles[i].replace(".java", ".class");
        }

        for (File file : files) {
            boolean keep = false;
            for (String classFile : classFilesToKeep) {
                if (file.getName().equals(classFile)) {
                    keep = true;
                    break;
                }
            }

            if (!keep) {
                if (file.delete()) {
                    log.info("Deleted: " + file.getName());
                } else {
                    log.info("Failed to delete: " + file.getName());
                }
            }
        }
    }
}
