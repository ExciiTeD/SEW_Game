package game_package;

import java.awt.*;

public abstract class PlayerObject {

    private  boolean up, down, left, right;
    protected int x, y;
    protected float velX =0, velY = 0;
    protected ID id;
    protected Handler handler;
    protected int height;
    protected int width;
    protected int moveSpeed;



    public PlayerObject(int x, int y, ID id, int width, int height, int moveSpeed){
        this.x = x;
        this.y = y;
        this.id = id;
        this.moveSpeed = moveSpeed;
        this.width = width;
        this.height = height;
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
