package com.company;

import java.util.Scanner;

public class CaesarCipher {
    public static String letters = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        int n = in.nextInt();
        int slip;
        for(int i=0;i<n;i++){
            str = in.next();
            slip = in.nextInt();
            System.out.println(coding(str, slip));
        }
        in.close();
    }

    public static String coding(String baseString, int slip) {
        baseString = baseString.toLowerCase();
        String resultString = "";

        for (int i = 0; i < baseString.length(); i++) {
            int bslet = letters.indexOf(baseString.charAt(i));
            int dd = (bslet - slip) % 26;
            if (dd < 0) {
                dd = letters.length() + dd;
            }
            char let = letters.charAt(dd);
            resultString = resultString + let;
        }
        return resultString.toUpperCase();
    }
}
