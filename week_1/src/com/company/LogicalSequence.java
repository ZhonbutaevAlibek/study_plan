package com.company;

import java.util.Scanner;

public class LogicalSequence {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int t = 0;

        if (Y % X != 0) {
            System.out.println("");
        }
        for (int i = 1; i <= Y; i++) {
            t++;
            System.out.print(i);
            if (t == X) {
                System.out.println("");
                t = 0;
            } else {
                System.out.print(" ");
            }
        }
        in.close();
    }
}
