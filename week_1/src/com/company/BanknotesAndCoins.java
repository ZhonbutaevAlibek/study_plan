package com.company;

import java.util.Scanner;

public class BanknotesAndCoins {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double sum = in.nextDouble();
        int isum = (int) sum;

        int[] arr = {100, 50, 20, 10, 5, 2};
        int amount;

        System.out.println("NOTAS:");
        for(int i=0; i < arr.length; i++){
            if(isum < arr[i]){
                System.out.println(0 + " nota(s) de R$ " + arr[i] + ".00");
            }
            else{
                amount = (int) Math.floor(isum/arr[i]);
                isum = isum - amount * arr[i];
                System.out.println(amount + " nota(s) de R$ " + arr[i] + ".00");
            }
        }

        int nsum = (int) Math.round((sum - (int)(sum - isum))*100);

        String[] sarr1 = {"1.00", "0.50", "0.25", "0.10", "0.05", "0.01"};
        int[] arr1 = {1, 50, 25, 10, 5, 1};

        System.out.println("MOEDAS:");

        if(nsum == 0){
            for(int i=0; i < arr1.length; i++){
                System.out.println(0 + " moeda(s) de R$ " + sarr1[i]);
            }
        }
        else{
            if(nsum >= 100){
                System.out.println("1 moeda(s) de R$ 1.00");
                nsum -= 100;
            }
            else{
                System.out.println("0 moeda(s) de R$ 1.00");
            }
            for(int i=1; i < arr1.length; i++){
                if(nsum < arr1[i]){
                    System.out.println(0 + " moeda(s) de R$ " + sarr1[i]);
                }
                else{
                    amount = (int) Math.floor(nsum/arr1[i]);
                    nsum = nsum - amount * arr1[i];
                    System.out.println(amount + " moeda(s) de R$ " + sarr1[i]);
                }
            }
        }

        in.close();
    }
}
