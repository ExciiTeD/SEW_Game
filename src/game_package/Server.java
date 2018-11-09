package game_package;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
   ServerSocket serverSocket;

    {
        try {
            serverSocket = new ServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
