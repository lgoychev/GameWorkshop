package gfx;

import java.awt.image.BufferedImage;




public class Assets {
    public static BufferedImage background;
    public static SpriteSheet player;
    public static SpriteSheet fighter;
    public static SpriteSheet menuButtons; //Game Menu

    public static void init() {

        background = ImageLoader.loadImage("/textures/background.jpg");
        player = new SpriteSheet(ImageLoader.loadImage("/textures/sprite1.png"));
        fighter = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_fighter.png"));
         menuButtons = new SpriteSheet(ImageLoader.loadImage("/textures/buttons.png"));


    }
}
