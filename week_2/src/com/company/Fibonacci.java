package com.company;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int numb;
        long  a=0, b=1;
        long z = 0;

        for(int i=0; i<n; i++){
            numb = in.nextInt();

            if(numb == 0){
                System.out.println("Fib(" + numb + ") = " + z);
            }
            else{
                for (int j = 2; j <= numb; j++) {
                    long next = a + b;
                    a = b;
                    b = next;
                }
                System.out.println("Fib(" + numb + ") = " + b);
            }
        }

        in.close();
    }
}
