package Game;

import Display.Display;

/**
 * Created by lgoychev on 4/9/16.
 */
public class Launcher {
    public static void main(String[] args) {
        game game = new game("Java Workshop! March 2016", 800,600);

        game.start();
    }
}
