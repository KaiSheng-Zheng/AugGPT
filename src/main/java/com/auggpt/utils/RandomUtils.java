package com.auggpt.utils;

import java.util.Random;

public class RandomUtils {
    private static final String STRING_TABLE = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random rd = new Random(System.currentTimeMillis());

    public static String generateRandomString(int len){
        int totlen = STRING_TABLE.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int idx = rd.nextInt(totlen);
            sb.append(STRING_TABLE.charAt(idx));
        }

        return sb.toString();
    }
}
