package com.company;

import java.util.Scanner;

public class GameTime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sh = in.nextInt();
        int sm = in.nextInt();
        int eh = in.nextInt();
        int em = in.nextInt();
        int m = 0;
        int h = 0;

        if (sh == eh && sm == em && sh == em) {
            System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
        } else {
            if (sh > eh) {
                h = 24 - sh + eh;
            }
            else if (sh < eh) {
                h = 24 - (24 - eh + sh);
            }

            if (sm > em) {
                m = 60 + em - sm;
                if (sh == eh) {
                    h = 24 + h - 1;
                }
                else {
                    h = h - 1;
                }
            }
            else {
                m = em - sm;
            }
            System.out.println("O JOGO DUROU " + h + " HORA(S) E " + m + " MINUTO(S)");
        }

        in.close();
    }
}
