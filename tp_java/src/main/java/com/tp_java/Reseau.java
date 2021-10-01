package com.tp_java;

import com.tp_java.Affichage;

public class Reseau {

    public static void HubReseau(){
        int awnser = MenueReseau();

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
        int ip = AskIP();
        try {
            Affichage.Print("Joining a game at ip = " + ip + " ...");
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect( new InetSocketAddress(ip, 8000));
            Affichage.Print("Sucessfully joined a game !");

        } catch (IOException e) {
            Affichage.PrintError("Error while trying to join game");
        }
    }

    public static String Message(){
        try{
            String message = Affichage.AskMessage();
            Write(message);
            return message;

        } catch(IOException e){
            Affichage.PrintError("Can't send message");
        }
    }

    public static void Write(String message){
        try{
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
            while(buffer.hasRemaining()){
                socket.Write(buffer);
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
            socket.Close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }
        
    }
}
