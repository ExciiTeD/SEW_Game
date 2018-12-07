package game_package;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends JFrame implements Runnable{

    private  static final long serialVersionUID = 1L;
    private Canvas canvas;
    private boolean isRunning;
    private Thread thread;
    private Handler handler;
    private String title;
    private Dimension dimension;
    private RenderHandler renderHandler;

    public Game(){
        canvas = new Canvas();
        dimension =  new Dimension(1000, 563);
        title  = "Dungeon Duels";
        isRunning = false;
        //KOMMENTAR FÜR GIT

        //Setting up the window
        setPreferredSize(this.dimension);
        setMaximumSize(this.dimension);
        setMinimumSize(this.dimension);
        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        //Canvas related things
        add(canvas);
        canvas.createBufferStrategy(3);

        handler = Handler.getInstance();
        handler.connect(new Wizard(100, 100, ID.Player));

        this.addKeyListener(new KeyInput(handler.playerObjects.get(0)));

        handler.connect(new Fighter(200, 200, ID.Player));
        this.addKeyListener(new KeyInput(handler.playerObjects.get(1)));


        renderHandler = new RenderHandler(getWidth(), getHeight());

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
            //System.out.println(frames);
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames =0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render(){
       BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        super.paint(graphics);
        ////////////////////////////////////
        renderHandler.render(graphics);
        //////////////////////////////////////
        graphics.dispose();
        bufferStrategy.show();


    }

    public static void main(String[] args) {
        new Game();
    }
}
