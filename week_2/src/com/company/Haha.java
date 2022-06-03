package com.company;

import java.util.Scanner;

public class Haha {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char str_a[] = str.toCharArray();
        char ans_s[] = new char[str_a.length];
        char ans_n[] = new char[str_a.length];
        int j = ans_s.length - 1;
        for (int i = 0; i < str_a.length; i++) {
            if (str_a[i] == 'a' || str_a[i] == 'e' || str_a[i] == 'i' || str_a[i] == 'o' || str_a[i] == 'u') {
                ans_s[j] = str_a[i];
                j--;
            }
        }
        j = 0;
        for (int i = 0; i < str_a.length; i++) {
            if (str_a[i] == 'a' || str_a[i] == 'e' || str_a[i] == 'i' || str_a[i] == 'o' || str_a[i] == 'u') {
                ans_n[j] = str_a[i];
                j++;
            }
        }
        String a = new String(ans_s);
        String b = new String(ans_n);
        a = a.trim();
        b = b.trim();
        if (a.equals(b)) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
