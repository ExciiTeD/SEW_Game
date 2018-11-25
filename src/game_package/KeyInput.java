package game_package;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(){
        this.handler = Handler.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject gameObject: handler.gameObjects) {
            if(gameObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W){handler.setUp(true);}
                if(key == KeyEvent.VK_A){handler.setLeft(true);}
                if(key == KeyEvent.VK_S){handler.setDown(true);}
                if(key == KeyEvent.VK_D){handler.setRight(true);}
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (GameObject gameObject: handler.gameObjects) {
            if(gameObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W){handler.setUp(false);}
                if(key == KeyEvent.VK_A){handler.setLeft(false);}
                if(key == KeyEvent.VK_S){handler.setDown(false);}
                if(key == KeyEvent.VK_D){handler.setRight(false);}
            }
        }

    }
}
