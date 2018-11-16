package game_package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Users implements  Runnable {

    DataOutputStream out;
    DataInputStream in;
    Users[] user = new Users[10];
    String name;
    int playerid;
    int playeridin;
    int xin;
    int yin;
    public Users(DataOutputStream out, DataInputStream in, Users[] users, int pid){
        this.out = out;
        this.in = in;
        this.user = users;
        this.playerid = pid;
    }

    @Override
    public void run() {
        try {
            out.writeInt(playerid);
            //name = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                playeridin = in.readInt();
                xin = in.readInt();
                yin = in.readInt();
                //String message = in.readUTF();
                for(int i=0; i < 10; i++){
                    if(user[i]!= null){
                        user[i].out.writeInt(playeridin);
                        user[i].out.writeInt(xin);
                        user[i].out.writeInt(yin);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                user[playerid] = null;
            }
        }
    }
}
