package Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by lgoychev on 4/16/16.
 */
public class MouseInput implements MouseListener{
    private Canvas canvas;
    public MouseInput(Canvas canvas){
        canvas.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        /*public Rectangle playButton = new Rectangle(100,150,100,50);
        public Rectangle helpButton = new Rectangle(100,250,100,50);
        public Rectangle quitButton = new Rectangle(100,350,100,50);*/

        //PlayButton
        if (mx >= 100 && mx<= 200){
            if(my >=100 && my <=200){
                //Pressed PlayButton
                game.state = game.STATE.GAME;
            }
        }
        //QuitButton
        if (mx >= 100 && mx<= 200){
            if(my >=350 && my <=400){
                //Pressed PlayButton
                System.exit(1);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
