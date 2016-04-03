package Game;
import Display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private String title;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private Thread thread;
    private boolean isRunning;

    private SpriteSheet sh;

    private int width = 110;
    private int height = 100;

    private int i = 0;


    /*Test*/
    //private int x; //Just testing

    public Game (String name) {
        this.title = name;
    }

    private void init() {
        Assets.init();

        this.display =  new Display (this.title);

        this.sh = new SpriteSheet(Assets.player, width, height);
        SpriteSheet background = new SpriteSheet(Assets.background, 800, 600);



        //this.x = 100;  //Just testing
    }


    private void tick(){
        //this.x++; //just testing
        i++;
            if (i >= 7) {
                i = 0;
            }
    }

    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null){
            this.display.getCanvas().createBufferStrategy(3);
            return;
        }

        this.g = this.bs.getDrawGraphics();

        g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);

        //Rectangle
        /*g.setColor(Color.red);
        g.fillRect(this.x, 200, 50, 50);

        g.setColor(Color.green);
        g.drawOval(100, 200, 20, 20);*/

        //Start drawing



            g.drawImage(this.sh.crop(i, 0),0, 0, null);



        //End drawing

        this.g.dispose();
        this.bs.show();

    }

    @Override
    public void run() {
        this.init();

        while (isRunning) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.tick();
            this.render();
        }

        this.stop();
    }
    public synchronized void strat() {
        this.thread = new Thread(this);
        this.isRunning = true;
        this.thread.start();
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
