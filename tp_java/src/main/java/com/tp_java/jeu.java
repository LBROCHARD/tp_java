package com.tp_java;

import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;

public class Jeu {

    static String color = "Empty";
    static Plateau plateau ;
    
    public static void Launch(){
        int awnser = Affichage.Menue();

        if(awnser == 1){
            LaunchReseau();
        } else {
            Local();
        }
    }

    public static void LaunchReseau(){
        Reseau.HubReseau();
    }

    public static void Local(){
        Affichage.Print("launching local mod ");
        plateau = new Plateau();
        Affichage.Print("everyone choose is color : Yellow (O) or Red (X)");
        color = RandomPlayer();
        Affichage.Print("the first player is : " + color );
        Tour();
    }

    public static String RandomPlayer(){
        Random r = new Random();
		int rndm = r.nextInt((2 - 1) + 1) + 1;
        // double rndm = Math.random()*(2 - 1 + 2 ) + 1;   
        if (rndm == 1) {
            return "Red";


        } else if (rndm == 2) {
            return "Yellow";

        } else {
            Affichage.PrintError("error in the selection of player, actually player = " + rndm);
            System.exit(0);
            return "error";
        }
    }

    public static void Tour(){
        Affichage.Print("c'est le tour du joueur " + color);
        Affichage.ShowBoard();
        int column = Affichage.AskColumn();
        plateau.FillColumn(column - 1);

        if (plateau.Victory() == true) {
            Affichage.Print("victoire !");

        } else {

            if (plateau.isPlateauFull() == true ){
                Affichage.Print("draw !");

            } else {
                if( color == "Yellow") {
                    color = "Red";

                } else {
                    color = "Yellow";
                }
                Tour();
            }
        }
    }

}
