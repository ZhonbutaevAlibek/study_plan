package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextDouble();
        }
        Arrays.sort(arr);

        double bcPowSum = Math.pow(arr[1], 2) + Math.pow(arr[0], 2);
        double aPow = Math.pow(arr[2], 2);

        if(arr[2] >= arr[1] + arr[0]){
            System.out.println("NAO FORMA TRIANGULO");
        }
        else if(aPow == bcPowSum){
            System.out.println("TRIANGULO RETANGULO");
        }
        else if(aPow > bcPowSum){
            System.out.println("TRIANGULO OBTUSANGULO");
        }
        else if(aPow < bcPowSum){
            System.out.println("TRIANGULO ACUTANGULO");
        }

        if(arr[0] == arr[1] && arr[1] == arr[2]){
            System.out.println("TRIANGULO EQUILATERO");
        }
        else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]){
            System.out.println("TRIANGULO ISOSCELES");
        }

        in.close();
    }
}
