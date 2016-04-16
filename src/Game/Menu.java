package Game;

import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;
import java.net.PortUnreachableException;

/**
 * Came Menu
 */
public class Menu {

    /*public Rectangle playButton = new Rectangle(350,150,100,50);
    public Rectangle helpButton = new Rectangle(350,250,100,50);
    public Rectangle quitButton = new Rectangle(350,350,100,50);*/

    private SpriteSheet playButton;
    private SpriteSheet helpButton;
    private SpriteSheet quitpButton;

    public Menu (){
        this.playButton = Assets.menuButtons;
    }

    public void render(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.CENTER_BASELINE,50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Falling Eggs",250,100);

        g.drawImage(this.playButton.crop(0,0,310,80), 100, 150, null);


        /*Font fnt1 = new Font("arial", Font.CENTER_BASELINE,30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("Play", playButton.x+19, playButton.y+30);
        g2d.draw(playButton);
        g.drawString("Help", helpButton.x+19, helpButton.y+30);
        g2d.draw(helpButton);
        g.drawString("Quit", quitButton.x+19, quitButton.y+30);
        g2d.draw(quitButton);*/

    }
}
