package com.auggpt.backend.utils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PDFParser {
    private final static Logger log = LogManager.getLogger("Log");

    public static String parsePDFtoString(String filePath){
        String result;
        PDDocument document;
        try(RandomAccessBufferedFileInputStream rabfs = new RandomAccessBufferedFileInputStream(new FileInputStream(filePath))) {
            org.apache.pdfbox.pdfparser.PDFParser parser = new org.apache.pdfbox.pdfparser.PDFParser(rabfs);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
            document.close();
            return result;
        }
        catch (FileNotFoundException e){
            log.error("File not found: check the file path configuration!",e);
            System.exit(130);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
