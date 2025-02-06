package com.auggpt.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.utils.RandomUtils.generateRandomString;

@Slf4j
public class TestClassFileBuilder {
    private static final String IMPORT_PACKAGES = "import org.junit.jupiter.api.*;\n" +
            "import java.lang.reflect.*;\n" +
            "import java.util.*;\n" +
            "import java.io.*;\n" +
            "import java.math.*;\n" +
            "\n" +
            "import static org.junit.jupiter.api.Assertions.*;\n";

    private String className;
    private StringBuilder content;
    private StringBuilder tmpContent;
    private StringBuilder out;
    public static String methodPattern = "(public|protected|private|static)?\\s*(void|[A-Za-z_]\\w*)\\s+([\\w$]+)\\s*\\([^\\)]*\\)\\s*(throws \\w+)*\\s*(\\{[^}]*\\})";



    public TestClassFileBuilder(String className, String content){
        this.content = new StringBuilder(content);
        this.className = className;
    }

    public TestClassFileBuilder(){
        this("TestClass","");
    }



    public void append(TestClassFileBuilder builder, boolean changeClassName){
        content.append("\n").append(builder.content);
        this.className = changeClassName ? builder.className : this.className;
    }



    public void appendClass(String classString){
        this.tmpContent = new StringBuilder(getClassContent(classString));
        tmpContent = buildString(tmpContent);
        tmpContent = deDuplicateMethodName(tmpContent);

        this.content.append("\n").append(getClassContent(tmpContent.toString()));
        buildString();
    }

    public StringBuilder buildString(StringBuilder input){
        input = new StringBuilder();
        input.append(IMPORT_PACKAGES + "\n\n" + "public class ")
                .append(className)
                .append(" {\n")
                .append(tmpContent)
                .append("\n")
                .append("}\n");
        return input;
    }

    public void buildString(){
        out = new StringBuilder();
        out.append(IMPORT_PACKAGES + "\n\n" + "public class ")
                .append(className)
                .append(" {\n")
                .append(content)
                .append("\n")
                .append("}\n");
    }

    public String getContent() {
        return content.toString();
    }

    public void setContent(String content) {
        this.content = new StringBuilder(content);
    }

    /**
     * Deduplicate the method name by append random string postfix.
     */
    private StringBuilder deDuplicateMethodName(StringBuilder input) {
        buildString();

        //  Regular expression for matching method names 
        //  The first group matching modifier 
        //  The second group "([\w\<\>\[\]]+\s+)"  Match return value.
        //  The third group "([\w]+)" Matching method name, that is, the part we need
        //  List of parameters for subsequent matching methods, exception, Method body 
        Pattern pat = Pattern.compile(methodPattern);
        String tmp = input.toString();
        tmp = tmp.replaceAll("\\$", "RDS_CHAR_DOLLAR");

        Matcher matcher = pat.matcher(tmp);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> methodMap =  new HashMap<>();

        while(matcher.find()) {
            String methodName = matcher.group(3);
            if(methodName.equals("for") || methodName.equals("while") || methodName.equals("do")){

            } else {
                String newMethodName = methodName+"_"+generateRandomString(4);
                matcher.appendReplacement(sb,matcher.group().replace(methodName, newMethodName));

                methodMap.put(methodName,newMethodName);
            }

        }
        matcher.appendTail(sb);

        String dedup = sb.toString();
        String newContent = dedup;
        for (String old : methodMap.keySet()) {

            String regex = "(\\b" + Pattern.quote(old) + "\\b)\\s*\\(";
            Pattern pattern = Pattern.compile(regex);
            Matcher oldMatcher = pattern.matcher(newContent);

            StringBuilder tmpsb = new StringBuilder();
            while (oldMatcher.find()) {
                oldMatcher.appendReplacement(tmpsb, methodMap.get(old)+"(");
            }
            oldMatcher.appendTail(tmpsb);
            newContent = tmpsb.toString();
        }

        dedup = newContent.replaceAll("RDS_CHAR_DOLLAR", "\\$");
        input = new StringBuilder(dedup);
        return input;
    }

    public String getResult() {
        buildString();
        return this.out.toString();
    }


    // utils:
    public static String getClassContent(String classString){
        int lf = classString.indexOf("{");
        int rt = classString.lastIndexOf("}");
        if (lf != -1 && rt != -1)
            return classString.substring(lf+1,rt);
        else
            return "";
    }

    /**
     * Split and output the code string including multiple classes into separate .java files
     *
     * @param code
     * @param absolutePath
     */
    public static void splitCode(String code, String absolutePath) {
        String[] classes = code.split("(?=\\b((public )?class)\\b\\s+\\w+\\s*\\{)");

        String[] imports = {
                "import static org.junit.jupiter.api.Assertions.*;",
                "import org.junit.jupiter.api.*;",
                "import java.util.*;"
        };

        for (String clazz : classes) {
            if (clazz.trim().isEmpty()) continue;

            String className = "UnknownClass";
            Pattern pattern = Pattern.compile("class\\s+(\\w+)");
            Matcher matcher = pattern.matcher(clazz);
            if (matcher.find()) {
                String oldName = matcher.group(1);
                className = oldName + "_" + generateRandomString(4);
                clazz = clazz.replace(oldName,className);
            }

            if (className.equals("UnknownClass")){
                continue;
            }

            String fileContent = buildFileContent(clazz, imports);
            writeToFile(className, fileContent, absolutePath);
        }
    }

    private static String buildFileContent(String classContent, String[] imports) {
        StringBuilder content = new StringBuilder();
        for (String imp : imports) {
            content.append(imp).append("\n");
        }
        content.append(classContent);
        return content.toString();
    }

    private static void writeToFile(String className, String content, String absolutePath) {
        try (FileWriter writer = new FileWriter(absolutePath+"\\"+className + ".java")) {
            writer.write(content);
            log.info("File written: " + className + ".java");
        } catch (IOException e) {
            log.error("Error writing file for class: " + className,e);
        }
    }

}
