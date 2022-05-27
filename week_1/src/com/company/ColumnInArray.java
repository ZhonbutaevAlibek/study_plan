package com.company;

import java.util.Scanner;

public class ColumnInArray {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        double result = 0.0;
        int n = in.nextInt();
        String s = in.next();
        double[][] Arr = new double[12][12];

        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                Arr[i][j] = in.nextDouble();
                if(j == n){
                    result += Arr[i][j];
                }
            }
        }

        if("S".equals(s)){
//            System.out.println(result);
            System.out.printf("%.1f\n", result);
        }
        else {
//            System.out.println(result / 12.0);
            System.out.printf("%.1f\n", (result / 12));
        }

        in.close();
    }
}
