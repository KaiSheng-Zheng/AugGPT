package com.auggpt.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class PDFParser {

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
