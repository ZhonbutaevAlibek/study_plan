package com.company;

import java.util.Scanner;

public class Combiner {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len1, len2, len3, k, l;
        char[] chStr1;
        char[] chStr2;

        String str1, str2;
        int n = in.nextInt();

        for(int i = 0; i < n; i++) {
            str1 = in.next();
            str2 = in.next();

            chStr1 = str1.toCharArray();
            chStr2 = str2.toCharArray();

            len1 = chStr1.length;
            len2 = chStr2.length;
            len3 = len1 + len2;

            char[] resultStr = new char[len3];

            if(len1 < len2) {
                for(k = 0, l = 0; k < len3; l++) {
                    if(k<len1*2) {
                        resultStr[k] = chStr1[l];
                        resultStr[k+1] = chStr2[l];
                        k += 2;
                    }
                    else {
                        resultStr[k] = chStr2[l];
                        k ++;
                    }
                }
                System.out.println(resultStr);
            }

            else {
                for(k = 0, l = 0; k < len3; l++) {
                    if(k < len2 * 2) {
                        resultStr[k] = chStr1[l];
                        resultStr[k+1] = chStr2[l];
                        k += 2;
                    }
                    else {
                        resultStr[k] = chStr1[l];
                        k ++;
                    }
                }
                System.out.println(resultStr);
            }
        }
        in.close();
    }
}
