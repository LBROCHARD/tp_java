package com.tp_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class affichage {
    
    public static int Menue(){
        affichage.Print("Do you want to play :");
        affichage.Print("1. online ");
        affichage.Print("2. local ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser =Integer.parseInt(br.readLine());  

            if(awnser == 1 || awnser == 2){
                return awnser;
            } else {
                affichage.PrintError("Awnser must be in the list");
                return Menue();
            }

        } catch(NumberFormatException e) {
            affichage.PrintError("Awnser must be a number : " + e.getMessage() );
            return Menue();

        } catch(IOException e) {
            affichage.PrintError("Error : " + e.getMessage() );
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

            affichage.Printf("|");
            for(int ii = 0; ii < 8 ; ii++) {

                affichage.Printf(String.valueOf(jeu.plateau.board[i][ii]));
            }
            affichage.Print("|");
        }
        affichage.Print("----------");
        affichage.Print(" 12345678 ");
    }
    
    public static int AskColumn(){
        Print("qu'elle colone voulez vous remplir ?");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser = Integer.parseInt(br.readLine());  

            if(awnser <= 8 && awnser > 0) {
                if (jeu.plateau.IsColonneFull(awnser - 1) == false) {
                    return awnser; 
                } else {
                    affichage.PrintError("This column is full");
                    return AskColumn();
                }

            } else {
                affichage.PrintError("Awnser must be beetween 1 and 8");
                return AskColumn();
            }

        } catch(NumberFormatException e) {
            affichage.PrintError("Awnser must be a number : " + e.getMessage() );
            return AskColumn();

        } catch(IOException e) {
            affichage.PrintError("Error : " + e.getMessage() );
            return AskColumn();

        }


    }
}