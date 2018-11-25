package game_package;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    private static Handler ourInstance = new Handler();
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
    private  boolean up, down, left, right;

    public static Handler getInstance() {
        return ourInstance;
    }

    private Handler() {
        up = false;
        down = false;
        left = false;
        right = false;
    }



    public void tick(){
        for (GameObject gameObject: gameObjects) {
            gameObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject gameObject: gameObjects) {
            gameObject.render(g);
        }
    }

    public void addObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    public void removeObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
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
}
