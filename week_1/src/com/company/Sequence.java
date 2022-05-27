package com.company;


public class Sequence {
    public static void main(String[] args) {
        for (double i = 0; i <= 2; i += 0.2) {
                System.out.println("I=" + check(i) + " J=" + check(i + 1));
                System.out.println("I=" + check(i) + " J=" + check(i + 2));
                System.out.println("I=" + check(i) + " J=" + check(i + 3));
        }
    }

    public static String check(double n){
        if(n<2 && n>1.9){
            return 2 + "";
        }
        else if(n - (int)n == 0){
            return (int)n + "";
        }
        else{
            return String.format("%.1f", n);
        }
    }

}
