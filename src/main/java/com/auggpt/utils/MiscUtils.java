package com.auggpt.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class MiscUtils {
    private MiscUtils(){}

    /**
     * Get current time
     * @return
     *      Current time: yyyy-MM-dd HH:mm:ss
     */
    public static String getNow(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Tested 2024.03.02
     * @param str xxxx98%xxxx
     * @return 0.98
     */
    public static ArrayList<String> findNum(String str){
        String pat = "\\d+";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(str);

        ArrayList<String> o = new ArrayList<>();

        while(matcher.find()){
            o.add(matcher.group());
        }

        return o;
    }

    /**
     * This method is designed just for a String:Double map.
     * @param map
     * @return
     */
    public static Map<String,Double> cloneHashMap(Map<String,Double> map){
        HashMap<String,Double> newMap = new HashMap<>();
        try{
            for(String k:map.keySet()){
                newMap.put(k, Double.parseDouble(String.valueOf(map.get(k))));
            }
        }catch (NumberFormatException e){
            log.error("Error occurred when clone a map.",e);
        }

        return newMap;
    }


    public static String codeBlockFormatter(String raw){
        Pattern pattern = Pattern.compile("(```\\S+\\s*)([\\s\\S]*?)(\\s*```)");
        Matcher matcher = pattern.matcher(raw);
        StringBuilder sb = new StringBuilder();
        while(matcher.find()) {
            sb.append(matcher.group(2)).append("\n");
        }
        return sb.toString();
    }

    public static ArrayList<String> codeBlockFormatterList(String raw){
        Pattern pattern = Pattern.compile("(```\\S+\\s*)([\\s\\S]*?)(\\s*```)");
        Matcher matcher = pattern.matcher(raw);
        ArrayList<String> list = new ArrayList<>();
        while(matcher.find()) {
            list.add(matcher.group(2));
        }
        return list;
    }


    /**
     * Calculate the number of tests by counting @Test annotated methods.
     * It based on an assumption that one line contains at most one @Test annotation.
     * @return number of tests. -1 if error.
     */
    public static int countTests(File file) {
        try {
            return countTests(new BufferedReader(new FileReader(file)));
        } catch (IOException e){
            log.error("error when counting tests",e);
        }
        return -1;
    }

    public static int countTests(String content) {
        return countTests(new BufferedReader(new StringReader(content)));
    }

    /**
     * Calculate the number of tests by counting @Test annotated methods.
     * It based on an assumption that one line contains at most one @Test annotation.
     * @return number of tests. -1 if error.
     */
    public static int countTests(BufferedReader reader) {
        int totMethod = 0;
        try(reader) {
            String line = null;
            Stack<String[]> stack = new Stack<>();
            int lineNum = 0;
            boolean isTest = false;

            while((line=reader.readLine()) != null){
                lineNum++;
                int matchNum = getOccur(line, "{")-getOccur(line, "}"); // possible multiple '{', '}'
                if (stack.size()==1 && !isTest) {
                    isTest = line.contains("@Test");
                }
                if(matchNum > 0){
                    for(int i=0;i<matchNum;i++){
                        stack.push(new String[]{line, lineNum+""});
                    }
                }else{
                    for(int i=0;i<-matchNum;i++){
                        if(stack.isEmpty()){
                            log.error("{} not match! line:"+lineNum);
                            return -1;
                        }
                        String[] popArr = stack.pop();
                        if(stack.size()==1){
                            if(isTest){
                                totMethod++;
                                isTest=false;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("error when counting tests",e);
        }
        return totMethod;
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
