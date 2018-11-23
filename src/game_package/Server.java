package game_package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ServerSocket serverSocket;
    static Users[] user = new Users[2];
    static int portNumber = 7777;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server");
        serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started");
        while(true){
            Socket socket = serverSocket.accept();
            for (int i = 0; i< user.length; i++){
                System.out.println("Connection from: " + socket.getInetAddress());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                if(user[i]==null){
                    System.out.println("USER CONNECTED");
                    user[i] = new Users(out,in,user, i);
                    Thread thread = new Thread(user[i]);
                    thread.start();
                    break;
                }
            }
        }
    }
}
