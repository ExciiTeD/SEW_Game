package game_package;

import java.io.DataInputStream;
import java.io.IOException;

public class Input implements Runnable{
    private DataInputStream in;
    private Client client;
    public Input(DataInputStream in, Client client){
        this.in = in;
        this.client = client;
    }

    @Override
    public void run() {
        while(true){
            try {
                int playerid = in.readInt();
                int x = in.readInt();
                int y = in.readInt();
                client.updateCoordinates(playerid, x, y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
