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

    public static void PrintError(String message){
        System.out.println("ERROR :" + message);
    }

    public static void ShowBoard(){
        affichage.Print("|" + plateau[1] + "|");
        affichage.Print("|" + plateau[2] + "|");
        affichage.Print("|" + plateau[3] + "|");
        affichage.Print("|" + plateau[4] + "|");
        affichage.Print("|" + plateau[5] + "|");
        affichage.Print("|" + plateau[6] + "|");
        affichage.Print("----------");
        affichage.Print(" 12345678 ");

    }

    public static int AskColumn(){
        affichage.Print("qu'elle colone voulez remplir ?");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser = Integer.parseInt(br.readLine());  

            if(awnser <= 8 && awnser > 0) {
                return awnser;
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
