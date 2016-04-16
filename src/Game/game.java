package Game;

import Display.Display;
import Game.entities.Fighter;
import Game.entities.Player;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import javafx.scene.layout.Background;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class game implements Runnable {
    private String name;
    private int widht, height;

    private boolean isRunning;

    private Thread thread;

    private Display display;

    private BufferStrategy bs;
    private Graphics g;

    private SpriteSheet sh;

    private InputHandler ih;
    private MouseInput mi;

    //Game menu
    
    public static enum STATE {
        MENU,
        GAME
    };

    public static STATE state = STATE.MENU;

    
    private Menu menu; // Game menu
    private Player bird;
    private Fighter john;
    


    //private SpriteSheet player; // testing without PLayer.java
    //private int col = 0; // testing without PLayer.java

    //end


    public game(String name, int widht, int height) {
        this.name = name;
        this.widht = widht;
        this.height = height;

    }
    public void init() {

        Assets.init();
        this.display = new Display(this.name, this.widht,this.height);
        this.ih = new InputHandler(this.display.getCanvas());
        this.mi = new MouseInput(this.display.getCanvas());

        this.bird = new Player(100, 100, 20);
        this.john = new Fighter(100, 437, 20);



         //Game Menu
        this.menu = new Menu();



        //this.player = Assets.player; // without Player.java

        //this.sh = new SpriteSheet(ImageLoader.loadImage("/textures/sprite1.png")); // without Assets



    }

    public void tick() {
       // Game Menu
        if (state == STATE.GAME){
            this.bird.tick();
            this.john.tick();
        }

      //before Game Menu
        //this.bird.tick();
        //this.john.tick();

      // without PLayer.java
        //this.col++;
        //this.col %= 9;





    }

    public void render() {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs ==null) {
            this.display.getCanvas().createBufferStrategy(2);
            this.bs = this.display.getCanvas().getBufferStrategy();
        }
        this.g = this.bs.getDrawGraphics();



        this.g.clearRect(0,0,this.widht,this.height);

        //start drawing
        this.g.drawImage(ImageLoader.loadImage("/textures/background.jpg"),0, 0, 800, 600, null);

        //Game Menu
        if (state == STATE.GAME) {
            this.bird.render(this.g);
            this.john.render(this.g);
        } else if (state == STATE.MENU){
            this.menu.render(this.g);


        }

        //SpriteSheet fighter = Assets.fighter;

      //Before Game Menu
        /*this.bird.render(this.g);
        this.john.render(this.g);*/

       //whithout PLayer.java
        //int imgWidth = 105;
        //int imgHeight = 99;

        //this.g.drawImage(this.sh.crop(9*imgWidth, 0, imgWidth, imgHeight), 100, 100, null); // without Assets

        //whithout PLayer.java
        //this.g.drawImage(player.crop(this.col*imgWidth, 0, imgWidth, imgHeight), 100, 100, null);

        //end drawing



        this.g.dispose();
        this.bs.show();

    }

    @Override
    public void run() {
        this.init();

        int fps = 10;
        double timePerTick = 1_000_000_000 / fps;
        double delta = 0;
        long now;
        long lastTimeTicked = System.nanoTime();


        while   (isRunning) {
            now = System.nanoTime();

            delta += (now - lastTimeTicked)/timePerTick;
            lastTimeTicked = now;

            if (delta > 1 ) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tick();
                render();
                delta --;
            }


        }

        this.stop();

    }

    public synchronized void start(){
        this.isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}