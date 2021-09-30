package com.tp_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Affichage {
    
    public static int Menue(){
        Affichage.Print("Do you want to play :");
        Affichage.Print("1. online ");
        Affichage.Print("2. local ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser =Integer.parseInt(br.readLine());  

            if(awnser == 1 || awnser == 2){
                return awnser;
            } else {
                Affichage.PrintError("Awnser must be in the list");
                return Menue();
            }

        } catch(NumberFormatException e) {
            Affichage.PrintError("Awnser must be a number : " + e.getMessage() );
            return Menue();

        } catch(IOException e) {
            Affichage.PrintError("Error : " + e.getMessage() );
            return Menue();
        }



    }

    public static void Print(String message){
        System.out.println(message);
    }

    public static void Printf(String message){
        System.out.print(message);
    }

    public static void PrintError(String message){
        System.out.println("ERROR :" + message);
    }

    public static void ShowBoard(){
        // Affichage.Print("|" + Jeu.plateau.board[0] + "|");
        // Affichage.Print("|" + Jeu.plateau.board[1] + "|");
        // Affichage.Print("|" + Jeu.plateau.board[2] + "|");
        // Affichage.Print("|" + Jeu.plateau.board[3] + "|");
        // Affichage.Print("|" + Jeu.plateau.board[4] + "|");
        // Affichage.Print("|" + Jeu.plateau.board[5] + "|");
        for(int i = 0; i < 6 ; i++) {

            Affichage.Printf("|");
            for(int ii = 0; ii < 8 ; ii++) {

                Affichage.Printf(String.valueOf(Jeu.plateau.board[i][ii]));
            }
            Affichage.Print("|");
        }
        Affichage.Print("----------");
        Affichage.Print(" 12345678 ");

    }

    public static int AskColumn(){
        Print("qu'elle colone voulez remplir ?");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser = Integer.parseInt(br.readLine());  

            if(awnser <= 8 && awnser > 0) {
                if (Jeu.plateau.IsColonneFull(awnser) == false) {
                    return awnser; 
                } else {
                    Affichage.PrintError("This column is full");
                    return AskColumn();
                }

            } else {
                Affichage.PrintError("Awnser must be beetween 1 and 8");
                return AskColumn();
            }

        } catch(NumberFormatException e) {
            Affichage.PrintError("Awnser must be a number : " + e.getMessage() );
            return AskColumn();

        } catch(IOException e) {
            Affichage.PrintError("Error : " + e.getMessage() );
            return AskColumn();

        }


    }
}
