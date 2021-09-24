package com.tp_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class affichage {
    
    public static int Menue(){
        System.out.println("Do you want to play :");
        System.out.println("1. online ");
        System.out.println("2. local ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            int awnser =Integer.parseInt(br.readLine());  
            
            if(awnser == 1 || awnser == 2){
                return awnser;
            } else {
                System.err.println("this choice is not correct");
                return Menue();
            }

        } catch(IOException e) {
            System.err.println("this awnser is wrong" + e.getMessage() );
            return Menue();
        }



    }

    public static void Show(){
        System.out.println("show");

    }

    public static void BoardAndAsk(){
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("----------");
        System.out.println(" 12345678 ");


        
    }
}
