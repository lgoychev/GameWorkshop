package Game;

import Game.entities.Fighter;
import Game.entities.Player;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener{
    private Canvas canvas;

    public InputHandler(Canvas canvas){
        canvas.addKeyListener(this);

    }
    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_RIGHT){
            Player.isMovingRight= true;
            Player.isMovingLeft= false;

        } else  if (code == KeyEvent.VK_LEFT){
            Player.isMovingRight= false;
            Player.isMovingLeft= true;
        }

        if (code == KeyEvent.VK_R){
            Fighter.isMovingRight= true;
            Fighter.isMovingLeft= false;

        } else  if (code == KeyEvent.VK_L){
            Fighter.isMovingRight= false;
            Fighter.isMovingLeft= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT){
            Player.isMovingRight= false;
            Player.isMovingLeft= false;
        } else  if (code == KeyEvent.VK_LEFT){
            Player.isMovingRight= false;
            Player.isMovingLeft= false;
        }

        if (code == KeyEvent.VK_R){
            Fighter.isMovingRight= false;
            Fighter.isMovingLeft= false;

        } else  if (code == KeyEvent.VK_L){
            Fighter.isMovingRight= false;
            Fighter.isMovingLeft= false;
        }
    }


}
