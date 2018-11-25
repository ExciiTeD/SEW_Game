package game_package;

import java.awt.*;

public class Fighter extends PlayerObject {

    private  boolean up, down, left, right;

    public Fighter(int x, int y, ID id){
        super(x, y, id, 32, 48);
        up = false;
        down = false;
        left = false;
        right = false;
    }
    @Override
    public void tick() {
        checkMovement();

        this.x += velX;
        System.out.println("X : " + x + "; VelX: " + velX);
        this.y += velY;
        System.out.println("Y : " + y + "; VelY: " + velY);


    }

    private void checkMovement() {
        if(this.isUp())velY = -5;
        else if(!this.isDown()) velY = 0;

        if(this.isDown())velY = 5;
        else if(!this.isUp()) velY = 0;

        if(this.isRight())velX = 5;
        else if(!this.isLeft()) velX = 0;

        if(this.isLeft())velX = -5;
        else if(!this.isRight()) velX = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x,this.y, this.width,this.height);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
}
