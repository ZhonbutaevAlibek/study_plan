package com.company;

import java.util.Scanner;

public class Flavious {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n, a, b;
        n = in.nextInt();

        for(int i = 0; i < n; i++){
            a = in.nextInt();
            b = in.nextInt();

            System.out.println("Case " + (i + 1) + ": " + flav(a,b));
        }

        in.close();
    }

    public static int flav(int x, int y) {
        int result = 0;
        for (int i = 2; i <= x; i++){
            result = (result + y) % i;
        }
        return result + 1;
    }
}
