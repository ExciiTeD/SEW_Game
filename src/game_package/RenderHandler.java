package game_package;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class RenderHandler {

    private BufferedImage view;
    private int[] pixels;
    private Handler handler;

    public RenderHandler(int width, int height){
        view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        handler = Handler.getInstance();
        pixels =((DataBufferInt) view.getRaster().getDataBuffer()).getData();
    }

    public void render(Graphics graphics){
        graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
        handler.render(graphics);
    }
}
