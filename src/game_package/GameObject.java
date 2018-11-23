package game_package;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    protected float velX =0, velY = 0;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
