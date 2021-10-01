package com.tp_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

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

<<<<<<< HEAD
    public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int N = 4;
		
		int C = 7;
		int L = 6;

		char[][] plateau = new char[C][L];
		
		for(int x = 0 ; x < C ; x++)
			for(int y = 0 ; y < L ; y++)
				plateau[x][y] = '.';
		
		int gagnant = 0;

        
			
		//affichage du plateau:
		
			
		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();
			
		for(int y = 0 ; y < L ; y++){
			System.out.print('|');
			for(int x = 0 ; x < C ; x++){
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}
			
		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();
        
=======
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
        Print("qu'elle colone voulez vous remplir ?");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser = Integer.parseInt(br.readLine());  

            if(awnser <= 8 && awnser > 0) {
                if (Jeu.plateau.IsColonneFull(awnser - 1) == false) {
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


>>>>>>> b9f3acecb9212df7581f5677d46a2027698572c7
    }
}