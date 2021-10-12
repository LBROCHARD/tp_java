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
            serverSocket.socket().bind(new InetSocketAddress(8000));
            SocketChannel socketChannel = serverSocket.accept();
            Affichage.PrintError("Listening on chanell 8000");


        } catch (IOException e) {
            Affichage.PrintError("Error while trying to host game");
        }

    }

    private static void JoinGame(){
        int ip = Affichage.AskIP();
        try {
            Affichage.Print("Joining a game at ip = " + ip + " ...");
            socket = SocketChannel.open();
            socket.connect(new InetSocketAddress(ip, 8000));   
            Affichage.Print("Sucessfully joined a game !");

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

    public String Read(){
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

    public void Close(){
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }
        
    }
}
