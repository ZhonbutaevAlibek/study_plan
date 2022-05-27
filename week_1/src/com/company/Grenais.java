package com.company;

import java.util.Scanner;

public class Grenais {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int game;
        int igoals, ggoals, iwins = 0, gwins = 0;
        int draw = 0, matches = 0;

        do{
            igoals = in.nextInt();
            ggoals = in.nextInt();

            if(igoals > ggoals){
                iwins ++;
            }
            else if(igoals < ggoals){
                gwins ++;
            }
            else{
                draw ++;
            }
            matches ++;

            System.out.println("Novo grenal (1-sim 2-nao)");
            game = in.nextInt();
        }while(game == 1);

        System.out.println(matches + " grenais");
        System.out.println("Inter:" + iwins);
        System.out.println("Gremio:" + gwins);
        System.out.println("Empates:" + draw);

        if(iwins > gwins){
            System.out.println("Inter venceu mais");
        }
        else if(iwins < gwins){
            System.out.println("Gremio venceu mais");
        }
        else{
            System.out.println("Não houve vencedor");
        }
        in.close();
    }
}
