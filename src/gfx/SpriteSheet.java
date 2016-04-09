package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by lgoychev on 4/9/16.
 */
public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;

    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return this.image.getSubimage( x, y, width, height);
    }
}
