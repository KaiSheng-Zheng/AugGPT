package com.auggpt.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamClearThread extends Thread
{
    private final BufferedReader reader;
    public StreamClearThread(InputStream stream) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    public void run()
    {
        try(reader) {
            String line;
            String lline = "";
            while (true) {
                line = reader.readLine();
                if (line == null) break;
                if (!line.equals(lline)) {
                    System.out.println(line);
                }
                lline = line;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
