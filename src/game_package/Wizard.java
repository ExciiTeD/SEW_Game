package game_package;

import java.awt.*;

public class Wizard extends GameObject {

    public Wizard(int x, int y, ID id){
        super(x, y, id);
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
        if(this.handler.isUp())velY = -5;
        else if(!handler.isDown()) velY = 0;

        if(this.handler.isDown())velY = 5;
        else if(!handler.isUp()) velY = 0;

        if(this.handler.isRight())velX = 5;
        else if(!handler.isLeft()) velX = 0;

        if(this.handler.isLeft())velX = -5;
        else if(!handler.isRight()) velX = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(this.x,this.y, 32,32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
