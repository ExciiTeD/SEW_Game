package game_package;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    protected float velX =0, velY = 0;
    protected ID id;
    protected Handler handler;



    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = Handler.getInstance();
    }


    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

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
