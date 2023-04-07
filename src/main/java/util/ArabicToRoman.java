package util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicToRoman {
    public static String arabicToRoman(int n) {

//        String result = "";
//
//        while (n >= 1000) {
//            result += "M";
//            n = n - 1000;
//        }
//
//        if (n >= 900) {
//            result += "CM";
//            n = n - 900;
//        }
//
//        if (n >= 500) {
//            result += "D";
//            n = n - 500;
//        }
//
//        if (n >= 400) {
//            result += "CD";
//            n = n - 400;
//        }
//
//        while (n >= 100) {
//            result += "C";
//            n = n - 100;
//        }
//
//        if (n >= 90) {
//            result += "XC";
//            n = n - 90;
//        }
//
//        if (n >= 50) {
//            result += "L";
//            n = n - 50;
//        }
//
//        if (n >= 40) {
//            result += "XL";
//            n = n - 40;
//        }
//
//        while (n >= 10) {
//            result += "X";
//            n = n - 10;
//        }
//
//        if (n >= 9) {
//            result += "IX";
//            n = n - 9;
//        }
//
//        if (n >= 5) {
//            result += "V";
//            n = n - 5;
//        }
//
//        if (n >= 4) {
//            result += "IV";
//            n = n - 4;
//        }
//
//        while (n > 0) {
//            result += "I";
//            n--;
//        }
//
//        return result;

        //Refactor:
        String result = "";
        HashMap<String, Integer> romanNumerals = new LinkedHashMap();

        romanNumerals.put("M", 1000);
        romanNumerals.put("CM", 900);
        romanNumerals.put("D", 500);
        romanNumerals.put("CD", 400);
        romanNumerals.put("C", 100);
        romanNumerals.put("XC", 90);
        romanNumerals.put("L", 50);
        romanNumerals.put("XL", 40);
        romanNumerals.put("X", 10);
        romanNumerals.put("IX", 9);
        romanNumerals.put("V", 5);
        romanNumerals.put("IV", 4);
        romanNumerals.put("I", 1);

        for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
            String roman = entry.getKey();
            Integer arabic = entry.getValue();

            if (arabic == 1000 || arabic == 100 || arabic == 10 || arabic == 1) {
                while (n >= arabic) {
                    result += roman;
                    n = n - arabic;
                }
            } else {
                if (n >= arabic) {
                    result += roman;
                    n = n - arabic;
                }
            }
        }
        return result;
    }
}
