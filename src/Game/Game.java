package Game;
import Display.Display;

public class Game implements Runnable{

    private Display display;
    private Thread thread;

    private String title;

    private boolean isRunning;

    public Game (String name) {
        this.title = name;
    }

    private void init() {
        this.display =  new Display (this.title);
    }

    private void tick(){

    }

    private void render(){

    }

    @Override
    public void run() {
        this.init();

        while (isRunning) {
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
