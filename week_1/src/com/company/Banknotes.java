package com.company;

import java.util.Scanner;

public class Banknotes{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();

        int[] arr = {100, 50, 20, 10, 5, 2, 1};
        int amount;

        System.out.println(sum);
        for(int i=0; i < arr.length; i++){
            if(sum < arr[i]){
                System.out.println(0 + " nota(s) de R$ " + arr[i] + ",00");
            }
            else{
                amount = (int) Math.floor(sum/arr[i]);
                sum = sum - amount * arr[i];
                System.out.println(amount + " nota(s) de R$ " + arr[i] + ",00");
            }
        }
        in.close();
    }
}