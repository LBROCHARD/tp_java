package com.tp_java;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
// import com.tp_java.Affichage;

public class Reseau {
    static SocketChannel socket = null;

    public static void HubReseau(){
        int awnser = Affichage.MenueReseau();

        if(awnser == 1) {
            HostGame();
        } else {
            JoinGame();
        }
    }
    

    private static void HostGame(){
        try {
            Affichage.Print("Hosting a game ...");
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(4004));
            socket = serverSocket.accept();
            Affichage.Print("Listening on chanell 4004");

            Jeu.CreatePlateau();
            String awnser = " " ;
            while ( !awnser.equals("Quit")) {
                awnser = Read();
                if(awnser.equals("Quit")){
                    break;
                } else if (awnser.equals("Victory")){
                    Affichage.Print("****************");
                    Affichage.Print("****************");
                    Affichage.Print("OTHER PLAYER WON");
                    Affichage.Print("****************");
                    Affichage.Print("****************");
                    break;
                } else if (awnser.equals("Draw")){
                    Affichage.Print("DRAW !");
                    break;
                } 
                Affichage.Print( ">>" + awnser);

                int colomn = Jeu.OnlineTour(Integer.parseInt(awnser));
                Write(String.valueOf(colomn));

                // awnser = Message();
            }
            Close();

        } catch (IOException e) {
            Affichage.PrintError("Error while trying to host game");
        }

    }

    private static void JoinGame(){
        String ip = Affichage.AskIP();
        try {
            Affichage.Print("Joining a game at ip = " + ip + " ...");
            socket = SocketChannel.open();
            socket.connect(new InetSocketAddress(ip, 4004));   
            Affichage.Print("Sucessfully joined a game !");

            Jeu.CreatePlateau();
            String awnser = " " ;
            int colomn = Jeu.OnlineTour(100);
            Write(String.valueOf(colomn));

            while ( !awnser.equals("Quit")) {
                awnser = Read();
                if(awnser.equals("Quit")){
                    break;
                } else if (awnser.equals("Victory")){
                    Affichage.Print("****************");
                    Affichage.Print("****************");
                    Affichage.Print("OTHER PLAYER WON");
                    Affichage.Print("****************");
                    Affichage.Print("****************");
                    break;
                } else if (awnser.equals("Draw")){
                    Affichage.Print("DRAW !");
                    break;
                }
                Affichage.Print( ">>" + awnser);

                colomn = Jeu.OnlineTour(Integer.parseInt(awnser));
                Write(String.valueOf(colomn));

                // awnser = Message();
            }
            Close();

        } catch (IOException e) {
            Affichage.PrintError("Error while trying to join game");
        }
    }

    public static String Message() throws IOException{
        String message = Affichage.AskMessage();
        Write(message);
        return message;
    }

    public static void Write(String message) throws IOException{
        try{
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
            while(buffer.hasRemaining()){
                socket.write(buffer);
            }
        }
        catch(UnsupportedEncodingException e){
            Affichage.Print("encoding not supported ");
        }
        
    }

    public static String Read(){
        ByteBuffer buffer = ByteBuffer.allocate(200);
        try {
            int bytesRead = socket.read(buffer);
            try{
                String message = new String(buffer.array(),0, bytesRead, "UTF-8");
                return message;
            }
            catch(UnsupportedEncodingException e){
                Affichage.PrintError("encoding not supported ");
            }
        }
        catch(IOException e){
            Affichage.PrintError("could not read from socket");
        }
        return "";
        
    }

    public static void Close(){
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }
        
    }

    
}
