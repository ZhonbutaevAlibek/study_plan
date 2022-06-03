package com.company;

import java.util.Scanner;

public class CompareSubstring {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String str1,str2;
        str1 = in.nextLine();
        str2 = in.nextLine();
        int len1=0, len2=0;

        for(int i=0;i<str1.length();i++) {
            for(int j=0;j<str2.length();j++) {
                if(str2.charAt(j)==str1.charAt(i)) {
                    len2=0;
                    for (int k = j, l = i;  l < str1.length(); k++,l++) {
                        if(str2.charAt(k)!=str1.charAt(l)) {
                            break;
                        }
                        len2++;
                    }
                    if(len2>len1){
                        len1=len2;
                    }
                }
            }
        }

        System.out.println(len1);
        in.close();
    }
}
