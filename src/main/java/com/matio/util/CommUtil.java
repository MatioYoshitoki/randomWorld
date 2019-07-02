package com.matio.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 公共的工具
 * @author choleece
 */
public class CommUtil {

    public static int null2Int(Object s) {
        int v = 0;
        if (s != null) {
            v = Integer.parseInt(s.toString());
        }
        return v;
    }

    public static float null2Float(Object s) {
        float v = 0.0F;
        if (s != null) {
            v = Float.parseFloat(s.toString());
        }
        return v;
    }

    public static double null2Double(Object s) {
        double v = 0.0D;
        if (s != null) {
            v = Double.parseDouble(null2String(s));
        }
        return v;
    }

	public static String null2String(Object s) {
		String str = s == null ? "" : s.toString().trim();
		str = "null".equals(s) ? "" : str.toString();
		return str;
	}

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        df.format(date);
        return df.format(date);
    }

    /**
     * 判空
     * @param s
     * @return
     */
    public static boolean checkNull(Object s){
        if (s == null || "".equals(s) || "undefined".equals(s)){
            return true;
        }
        return false;
    }

    public static final String randomCode(int length) {
        char[] numbersAndLetters = "0123456789"
                .toCharArray();
        if (length < 1) {
            return "";
        }
        Random randGen = new Random();
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(9)];
        }
        return new String(randBuffer);
    }
}