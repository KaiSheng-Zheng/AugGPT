package com.auggpt.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.auggpt.service.CompileService.compile;
import static com.auggpt.utils.CommandLineUtils.run_cmd;
import static com.auggpt.utils.IOUtils.*;
import static com.auggpt.utils.IOUtils.cleanUp;
import static com.auggpt.utils.MiscUtils.findNum;

@Slf4j
public class MutationTester {

    private HashMap<String,String> systemProperties;
    private boolean mutationTestLaunchFlag = false;
    public HashMap<String,Double> mutationResults = new HashMap<>();


    // ******************
    // Mutation test indicators
    public static final String LC = "Line Coverage";
    public static final String MU_GEN = "Mutations generated";
    public static final String MU_KILL = "Mutations killed";
    public static final String MU_COVER = "Mutations coverage rate";
    public static final String MU_KILL_RATE = "Mutations killed rate";
    public static final String TOT_TEST = "total tests";
    public static final String TEST_STRENGTH = "Test strength";
    private static final double TEST_STRENGTH_DELTA = 0.2;
    // ******************


    public MutationTester(HashMap<String, String> systemProperties) {
        this.systemProperties = systemProperties;
    }

    /**
     * Tested
     * @param systemProperties
     * @param testPath
     */
    public void evaluateTestMutation(HashMap<String,String> systemProperties, String testPath) throws IOException {

        String cmdOrigin = readFile("data\\core\\PIT_script_raw.bat");
        cmdOrigin = cmdOrigin.replace("TEST_PATH", testPath);
        cmdOrigin = cmdOrigin.replace("TARGET_PATH", systemProperties.get("targetPath"));

        StringBuilder libs = new StringBuilder();
        libs.append(systemProperties.get("PITLibPath")).append("\\*;");
        libs.append(systemProperties.get("Junit5LibPath")).append("\\*;");

        libs.deleteCharAt(libs.length()-1);

        cmdOrigin = cmdOrigin.replace("PIT_LIB", libs);
        cmdOrigin = cmdOrigin.replace("PIT_PATH", systemProperties.get("PITLibPath"));

        File pitReport = new File(systemProperties.get("PITReportPath")+"/"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss")));
        if (!pitReport.exists()) {
            boolean mkdir = pitReport.mkdirs();
            if(mkdir) log.info("Create PITest report directory at {} successfully.",pitReport.getAbsolutePath());
        }
        cmdOrigin = cmdOrigin.replace("REPORT_DIR", pitReport.getAbsolutePath());//-target TARGET_PATH -base_dir BASE_DIR_PATH

        String[] tests_ = getClassesNames(testPath);
        String[] targets_ = getClassesNames(systemProperties.get("targetPath"));

        String tests = String.join(",",tests_);
        String targets = String.join(",",targets_);

        cmdOrigin = cmdOrigin.replace("TESTS", tests);
        cmdOrigin = cmdOrigin.replace("TARGETS", targets);//-target TARGET_PATH -base_dir BASE_DIR_PATH

        cmdOrigin = cmdOrigin.replace("SRC_DIR", systemProperties.get("rootPath"));

        writeFile("data\\core\\PIT_script.bat", cmdOrigin);

        String tempReportPath = systemProperties.get("rootPath") + "\\temp\\PITResult";

        String tempStdReportPath = tempReportPath + "\\out";
        String tempErrReportPath = tempReportPath + "\\err";

        File tempReport = new File(tempReportPath);
        File tempStdReport = new File(tempStdReportPath);
        File tempErrReport = new File(tempErrReportPath);

        tempReport.mkdirs();

        tempStdReport.createNewFile();
        tempErrReport.createNewFile();

        run_cmd("data\\core\\PIT_script.bat",tempStdReportPath,tempErrReportPath);

        BufferedReader reader = new BufferedReader(new FileReader(tempStdReport));

        String[] result = new String[4];
        int rp = 0;
        try(reader){
            String line;
            boolean startStore = false;
            while((line = reader.readLine())!=null){
                if(startStore){
                    if(line.contains("Enhanced functionality available at")){
                        break;
                    }
                    result[rp++] = line;
                }
                if(!startStore && line.contains("Statistics")){
                    startStore = true;
                    reader.readLine(); // skip separation line ===============================
                }
            }
            mutationTestLaunchFlag = true;
        }catch (IOException e){
            log.error("Error occurred when reading PITest report",e);
        }
        mutationResultAnalyse(mutationResults, result);
    }

    /**
     * Notice that this is hard-coded.
     *
     * @param map
     * @param result
     */
    private static void mutationResultAnalyse(Map<String,Double> map, String[] result){

        map.put(LC,Double.parseDouble(findNum(result[0]).get(2))/100d);

        ArrayList<String> temp = findNum(result[1]);
        map.put(MU_GEN, Double.parseDouble(temp.get(0)));
        map.put(MU_KILL,Double.parseDouble(temp.get(1)));
        map.put(MU_COVER,1 - Double.parseDouble(findNum(result[2]).get(0))/Double.parseDouble(temp.get(0)));
        map.put(MU_KILL_RATE, Double.parseDouble(temp.get(1))/Double.parseDouble(temp.get(0)));

        temp = findNum(result[2]);
        map.put(TEST_STRENGTH,Double.parseDouble(temp.get(1))/100d);
    }

    private Map<String, ArrayList<String>> analyseMutationReport(String filePath){
        if (!mutationTestLaunchFlag){
            log.error("Launch mutation test before analyse the report!");
            return null;
        }
        Pattern pat = Pattern.compile(" Location : (.*) Killed by : none (.*)");

        File file = new File(filePath);
        try {
            File[] files = file.listFiles();
            StringBuilder sb = new StringBuilder();
            for (File fhtml:files){
                String html = org.apache.commons.io.FileUtils.readFileToString(fhtml, "UTF-8");

                Document doc = Jsoup.parse(html);

                for (Element p : doc.select("p")) {
                    String ptext = p.text();
                    if (!ptext.contains("KILLED")){
                        sb.append(ptext).append("\n");
                    }
                }
            }

            Matcher matcher = pat.matcher(sb);
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            while(matcher.find()) {
                String location = matcher.group(1);
                String info = matcher.group(2);

                ArrayList<String> mutants = map.getOrDefault(location,new ArrayList<>());
                mutants.add(info);
                map.put(location,mutants);
            }
            mutationTestLaunchFlag = false;
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, ArrayList<String>> getMutationInfo() {
        try{
            cleanUp(systemProperties.get("testPath"),false);
            cleanUp(systemProperties.get("targetPath"),false);

            compile(systemProperties.get("programRootPath"),systemProperties.get("libPath"),
                    systemProperties.get("targetPath"),systemProperties.get("programRootPath"),systemProperties);

            compile(systemProperties.get("targetPath"),systemProperties.get("libPath"),
                    systemProperties.get("testPath"),systemProperties.get("GPTTestPath"),systemProperties);

            evaluateTestMutation(systemProperties, systemProperties.get("testPath"));
            File PITReportDir = new File(systemProperties.get("PITReportPath"));
            if (!PITReportDir.exists()){
                log.error("PITReport directory not exist");
            }

            File[] reports = PITReportDir.listFiles();
            Map<String,ArrayList<String>> map = analyseMutationReport(reports[reports.length-1].getAbsolutePath()+"\\default");
            return map;
        } catch (Exception e){
            log.error("Error when get mutation information",e);
        }
        return new HashMap<>();
    }
}
