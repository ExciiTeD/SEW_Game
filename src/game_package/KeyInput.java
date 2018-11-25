package game_package;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private PlayerObject playerObject;
    private boolean isWizard;

    public KeyInput(PlayerObject playerObject){
        this.handler = Handler.getInstance();
        this.isWizard = playerObject instanceof Wizard;
        this.playerObject =  playerObject;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(isWizard){
            if(key == KeyEvent.VK_W){((Wizard)playerObject).setUp(true);}
            if(key == KeyEvent.VK_A){((Wizard)playerObject).setLeft(true);}
            if(key == KeyEvent.VK_S){((Wizard)playerObject).setDown(true);}
            if(key == KeyEvent.VK_D){((Wizard)playerObject).setRight(true);}
        }
        else {
            if(key == KeyEvent.VK_UP){((Fighter)playerObject).setUp(true);}
            if(key == KeyEvent.VK_LEFT){((Fighter)playerObject).setLeft(true);}
            if(key == KeyEvent.VK_DOWN){((Fighter)playerObject).setDown(true);}
            if(key == KeyEvent.VK_RIGHT){((Fighter)playerObject).setRight(true);}
        }


        }


    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(isWizard){
            if(key == KeyEvent.VK_W){((Wizard)playerObject).setUp(false);}
            if(key == KeyEvent.VK_A){((Wizard)playerObject).setLeft(false);}
            if(key == KeyEvent.VK_S){((Wizard)playerObject).setDown(false);}
            if(key == KeyEvent.VK_D){((Wizard)playerObject).setRight(false);}
        }
        else {
            if(key == KeyEvent.VK_UP){((Fighter)playerObject).setUp(false);}
            if(key == KeyEvent.VK_LEFT){((Fighter)playerObject).setLeft(false);}
            if(key == KeyEvent.VK_DOWN){((Fighter)playerObject).setDown(false);}
            if(key == KeyEvent.VK_RIGHT){((Fighter)playerObject).setRight(false);}
        }

        }

    }

