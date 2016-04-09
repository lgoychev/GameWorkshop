package Game.entities;

import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;




public class Player {



    private  int x,y, width, height, velocity, hitPoints;
    private SpriteSheet img;
    private Rectangle boundingBox;
    private int column = 0;
    private int row = 0;

    public static boolean isMovingLeft, isMovingRight;

    public Player (int x, int y, int hitPoints) {



        this.x = x;
        this.y = y;
        this.velocity = 10;
        this.width = 105;
        this.height = 99;
        this.hitPoints = hitPoints;
        this.img = Assets.player;
        this.boundingBox = new Rectangle(x,y, this.width, this.height);

    }

    public void tick() {
        if (isMovingRight) {
            this.x += this.velocity;
            this.row = 0;
            this.column++;
            this.column %= 10;
            } else  if (isMovingLeft){
            this.x -= this.velocity;
            this.row = 1;
            this.column++;
            this.column %= 10;
        } else {
            this.row = 0;
            this.row = 0;

        }

        this.boundingBox.setBounds(this.x, this.y, this.width, this.height);
    }

    public void render(Graphics g) {

            g.drawImage(this.img.crop(this.column*this.width,this.row*this.height,this.width, this.height),
                    this.x,
                    this.y,
                    null );


    }


}
