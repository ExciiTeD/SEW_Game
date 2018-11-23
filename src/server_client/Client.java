package server_client;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends JPanel implements Runnable, KeyListener {

    static Socket socket;
    static DataOutputStream out;
    static DataInputStream in;
    static String hostAddress = "localhost";
    static int portNumber = 7777;

    int playerid;
    int[] x = new int[2];
    int[] y = new int[2];

    boolean left,right,up,down;

    int playerx;
    int playery;

    public Client(){
        addKeyListener(this);
        //run();
    }
    /*
    public  void init() {

        addKeyListener(this);
        try {
            System.out.println("Connecting...");
            socket = new Socket(hostAddress, 7777);
            System.out.println("Connected");
            in = new DataInputStream(socket.getInputStream());
            playerid = in.readInt();
            out = new DataOutputStream(socket.getOutputStream());

            Input input = new Input(in, this);
            Thread thread = new Thread(input);
            thread.start();
            Thread second_thread = new Thread(this);
            second_thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
    public  void updateCoordinates(int pid, int x, int y){
        this.x[pid] = x;
        this.y[pid] = y;
    }
    public void paint(Graphics g){
        g.drawOval(playerx, playery, 5, 5);
    }


    @Override
    public void run() {
        while(true){
            if(right){
                playerx +=10;
            }
            if(left){
                playerx -=10;
            }
            if(up){
                playery +=10;
            }
            if(down){
                playery -=10;
            }
            if(right || left || up || down){
                try {
                    out.writeInt(playerid);
                    out.writeInt(playerx);
                    out.writeInt(playery);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37){
            left = true;
        }
        if(e.getKeyCode() == 38){
            up = true;
        }
        if(e.getKeyCode() == 39){
            right = true;
        }
        if(e.getKeyCode() == 40){
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 37){
            left = false;
        }
        if(e.getKeyCode() == 38){
            up = false;
        }
        if(e.getKeyCode() == 39){
            right = false;
        }
        if(e.getKeyCode() == 40){
            down = false;
        }
    }
}
