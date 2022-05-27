package com.company;

import java.util.Scanner;
import java.text.DecimalFormat;

public class WeightedAverages {
    public static void main(String args[]){
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner in = new Scanner(System.in);
        int aw = 2;
        int bw = 3;
        int cw = 5;

        int n = in.nextInt();
        int i = 0;

        while(i < n){
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double avgWeight = (a*aw + b*bw + c*cw) / (aw + bw + cw);
            System.out.println(df.format(avgWeight));
            i++;
        }
    }
}
