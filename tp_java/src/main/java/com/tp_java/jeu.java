package com.tp_java;

import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;

public class jeu {

    static String color = "Empty";
    
    public static void Launch(){
        int awnser = affichage.Menue();

        if(awnser == 1){
            Reseau();
        } else {
            Local();
        }
    }

    public static void Reseau(){
        affichage.Print("! Online is a work in progress !");
        affichage.Print("please select something else in the menu");
        Launch();

    }

    private static void HostGame(){
        try {
            affichage.Print("Hosting a game ...");
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(8000));
            SocketChannel socketChannel = serverSocket.accept();
            affichage.PrintError("Listening on chanell 8000");


        } catch (IOException e) {
            affichage.PrintError("Error while trying to host game");
        }

    }

    private static void JoinGame(){
        try {
            affichage.Print("Joining a game ...");
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect( new InetSocketAddress("localhost", 8000));
            affichage.PrintError("Sucessfully joined a game !");

        } catch (IOException e) {
            affichage.PrintError("Error while trying to join game");
        }
    }

    public static void Local(){
        affichage.Print("launching local mod ");
        color = RandomPlayer();
        affichage.Print("the first player is : " + color);
    }

    public static String RandomPlayer(){
        Random r = new Random();
		int rndm = r.nextInt((2 - 1) + 1) + 1;
        // double rndm = Math.random()*(2 - 1 + 2 ) + 1;   
        if (rndm == 1) {
            String color = "Red";
            return color;


        } else if (rndm == 2) {
            String color = "Yellow";
            return color;

        } else {
            affichage.PrintError("error in the selection of player, actually player = " + rndm);
            System.exit(0);
            return "error";
        }
    }

    public static void Tour(){

        
    }

}
