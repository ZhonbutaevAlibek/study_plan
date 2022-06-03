package com.company;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num, sum;
        int n = in.nextInt();

        while(n > 0){
            sum = 0;
            num = in.nextInt();
            if(num % 2 != 0){
                System.out.println(num + " nao eh perfeito");
            }
            else{
                for (int i= num / 2; i >= 1; i--) {
                    if (num % i == 0) {
                        sum += i;
                    }
                }
                if (num == sum) {
                    System.out.println(num + " eh perfeito");
                }
                else{
                    System.out.println(num + " nao eh perfeito");
                }
            }
            n--;
        }

        in.close();
    }
}
