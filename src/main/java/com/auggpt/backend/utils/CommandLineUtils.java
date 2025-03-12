package com.auggpt.backend.utils;

import com.auggpt.backend.model.FileStreamClearThread;
import com.auggpt.backend.model.StreamClearThread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class CommandLineUtils {
    private final static Logger log = LogManager.getLogger("Log");
    public static void run_cmd_example(){
        String strcmd = "data\\core\\example.bat";
        run_cmd(strcmd);
    }
    public static void run_cmd(String strcmd) {

        Runtime rt = Runtime.getRuntime();
        Process ps = null;
        try {
            ps = rt.exec(strcmd);
            new StreamClearThread(ps.getInputStream()).start();
            new StreamClearThread(ps.getErrorStream()).start();
            ps.waitFor();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        }

        int i = 1;
        if (ps != null) {
            i = ps.exitValue();
        }
        if (i == 0) {
            log.info("Success.");
        } else {
            log.error("Failed.");
        }

        if (ps != null) {
            ps.destroy();
        }
        ps = null;
    }

    public static void run_cmd(String strcmd, String stdFilePath, String errFilePath) {

        Runtime rt = Runtime.getRuntime();
        Process ps = null;
        try {
            ps = rt.exec(strcmd);
            new FileStreamClearThread(ps.getInputStream(),stdFilePath).start();
            new FileStreamClearThread(ps.getErrorStream(),errFilePath).start();

            ps.waitFor();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        }

        int i = 1;
        if (ps != null) {
            i = ps.exitValue();
        }
        if (i == 0) {
            log.info("CMD run success.");
        } else {
            log.error("CMD run failed.");
        }

        if (ps != null) {
            ps.destroy();
        }
        ps = null;
    }
}



