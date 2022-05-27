package com.company;

import java.util.Scanner;

public class Population {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int c;
        int check;
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            check = 0;
            c = 0;
            double a = in.nextDouble();
            double b = in.nextDouble();
            double ai = in.nextDouble();
            double bi = in.nextDouble();

            while(a <= b){
                a += a * ai / 100;
                b += b * bi / 100;

                c++;

                if(c > 100){
                    check = 1;
                    break;
                }
            }

            if(check == 1){
                System.out.println("Mais de 1 seculo.");
            }
            else{
                System.out.println(c + " anos.");
            }
        }

        in.close();
    }
}
