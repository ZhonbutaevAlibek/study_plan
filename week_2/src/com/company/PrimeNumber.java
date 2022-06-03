package com.company;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        int n = in.nextInt();

        while(n > 0){
            number = in.nextInt();
            if(!primeNum(number)){
                System.out.println(number + " nao eh primo");
            }
            else{
                System.out.println(number + " eh primo");
            }
            n--;
        }
        in.close();
    }

    public static boolean primeNum(int x){
        if (x <= 1)
            return false;
        else if (x <= 3)
            return true;
        else if (x % 2 == 0 || x % 3 == 0)
            return false;

        int n = 5;
        while (n * n <= x){
            if (x % n == 0 || x % (n + 2) == 0){
                return false;
            }
            n += 6;
        }
        return true;
    }

}
