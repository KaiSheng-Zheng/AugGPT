package com.auggpt;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


/**
 * This will calculate the average method lines for the test suites retrieved by three approaches.
 */
public class CalculateAML {
    @Test
    public void main() {
        System.out.println("---------AML for human written tests---------");
        File dir = new File("dataset/human_tests");
        for (File subdir :
                dir.listFiles()) {
            searchDir(subdir);
        }
        System.out.println("---------AML for human written tests---------");

        System.out.println();

        System.out.println("---------AML for plain-approach generated tests---------");
        dir = new File("dataset/plain_tests");
        for (File subdir :
                dir.listFiles()) {
            searchDir(subdir);
        }
        System.out.println("---------AML for plain-approach generated tests---------");
        System.out.println();

        System.out.println("---------AML for AugGPT-generated tests---------");
        dir = new File("dataset/AugGPT_tests");
        for (File subdir :
                dir.listFiles()) {
            searchDir(subdir);
        }
        System.out.println("---------AML for AugGPT-generated tests---------");

    }



    private void searchDir(File dir) {
        AMLValue amlValue = new AMLValue();

        if(dir.isDirectory()){
            if (dir.getName().equals("testcases")) return;
            for(File file : dir.listFiles()){
                if(file.isDirectory()){
                    // human_tests/chess contains its testcases text files, no need to count
                    searchDir(file);
                }
                if(file.isFile() && file.getName().endsWith("java")){
                    statInFile(file,amlValue);
                }

            }
        }else{
            statInFile(dir,amlValue);
        }

        System.out.println("_____________________");
        System.out.println("Stats of file under path: "+dir.getAbsolutePath());
        System.out.println("Methods: "+amlValue.totMethod);
        System.out.println("Method Lines: "+amlValue.totLine);
        System.out.println("AML: "+amlValue.getAML());
    }


    private void statInFile(File file, AMLValue amlValue) {
        BufferedReader reader = null;
        int totLine = 0;
        int totMethod = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            Stack<String[]> stack = new Stack<>();
            int lineNum = 0;

            boolean testMethod = false;

            reader = new BufferedReader(new FileReader(file));
            line = null;
            stack = new Stack<>();
            lineNum = 0;

            while((line=reader.readLine()) != null){
                if (!isLineLogical(line)) continue;

                lineNum++;
                int matchNum = getOccur(line, "{")-getOccur(line, "}");
                if(!testMethod) testMethod = line.contains("@Test");

                if(matchNum > 0){
                    for(int i=0;i<matchNum;i++){
                        stack.push(new String[]{line, lineNum+""});
                    }
                }else{
                    for(int i=0;i<-matchNum;i++){
                        if(stack.isEmpty()){
                            return;
                        }
                        String[] popArr = stack.pop();
                        if(stack.size()==1){
                            int beginNum = Integer.parseInt(popArr[1]);
                            if (testMethod) {
                                totMethod++;
                                totLine+=lineNum-beginNum;
                                testMethod = false;
                            }
                        }
                    }
                }
            }
            amlValue.totLine += totLine;
            amlValue.totMethod += totMethod;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int getOccur(String src, String find) {
        int o = 0;
        int index = -1;
        while ((index = src.indexOf(find, index)) > -1) {
            ++index;
            ++o;
        }
        return o;
    }

    /**
     * Check whether the line is an executable line.
     * @param line
     * @return
     */
    private boolean isLineLogical(String line){
        line = line.trim();
        return !line.isBlank() && !line.startsWith("//") && !line.startsWith("/*") && !line.endsWith("*/");
    }

    static class AMLValue{
        int totMethod = 0;
        int totLine = 0;
        int testMethod = 0;

        public AMLValue() {
        }

        double getAML(){
            return (double)totLine/totMethod;
        }
    }
}

