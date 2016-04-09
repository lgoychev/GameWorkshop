package gfx;

import java.awt.image.BufferedImage;




public class Assets {
    public static BufferedImage background;
    public static SpriteSheet player;

    public static void init() {

        background = ImageLoader.loadImage("/textures/background.jpg");
        player = new SpriteSheet(ImageLoader.loadImage("/textures/sprite1.png"));

    }
}
