package game_package;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private  static final long serialVersionUID = 1L;

    private boolean isRunning = false;
    private Thread thread;

    public Game(){
        new ClientWindow(1000, 563, "Dungeon Duels", this);
        start();
    }

    public void start(){
        this.isRunning= true;
        this.thread = new Thread(this);
        thread.start();
    }
    public void stop(){
        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames =0;
            }
        }
        stop();
    }

    private void tick() {

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        ////////////////////////////////////
        g.setColor(Color.RED);
        g.fillRect(0, 00,1000,20);
        //////////////////////////////////////

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
