package com.auggpt.model;

import java.io.*;

/**
 *
 */
public class FileStreamClearThread extends Thread
{
    private final BufferedReader reader;
    private final BufferedWriter writer;
    public FileStreamClearThread(InputStream stream, String file) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(stream));
        this.writer = new BufferedWriter(new FileWriter(file));
    }

    public void run()
    {
        try(reader;writer) {
            String line;
            String lline = "";
            while (true) {
                line = reader.readLine();
                if (line == null) break;
                if (!line.equals(lline)) {
                    System.out.println(line);
                    writer.write(line+"\n");
                }
                lline = line;
            }
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
