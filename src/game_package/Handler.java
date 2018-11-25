package game_package;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    private static Handler ourInstance = new Handler();
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    LinkedList <PlayerObject> playerObjects = new LinkedList<PlayerObject>();

    private int maxPlaySize = 4;

    public static Handler getInstance() {
        return ourInstance;
    }

    private Handler() {
    }

    public void connect(PlayerObject playerObject){
        if(playerObjects.size() < maxPlaySize -1){
            playerObjects.add(playerObject);
        }
        else {
            System.out.println("Zu viele  Spieler");
        }
    }

    public void tick(){
        for (GameObject gameObject: gameObjects) {
            gameObject.tick();
        }
        for (PlayerObject playerObject: playerObjects){
            playerObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject gameObject: gameObjects) {
            gameObject.render(g);
        }
        for (PlayerObject playerObject: playerObjects){
            playerObject.render(g);
        }
    }

    public void addGameObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
    }

}
