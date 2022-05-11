import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ThePanel extends JPanel implements Runnable{

    // Declare as final so don't modify value
    // Makes code run appreciately faster when declaring final
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555)); //Ratio of standard ping-pong table
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT); //Screen Size; Width, Height
    static final int BALL_DIAMETER = 20; //Ball Diameter
    static final int PADDLE_WIDTH = 25; //Paddle Width
    static final int PADDLE_HEIGHT = 25; //Paddle Height

    //Declare instances
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    ThePaddle paddle1; //Player 1's Paddle
    ThePaddle paddle2; //Player 2's Paddle
    TheBall ball;
    TheScore score;


    ThePanel(){ //Constructor
        newPaddles(); //Call method
        newBall();
        score = new TheScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true); //Read key presses
        this.addKeyListener(new Ltener());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this); //Implementing Runnable interface
        gameThread.start();

    }
    public void newBall() {

    }
    public void newPaddles(){
        paddle1 = new ThePaddle(0,(GAME_HEIGHT/2) -(PADDLE_WIDTH/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new ThePaddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);


    }
    public void paint (Graphics g) {
        image = createImage(getWidth(),getHeight()); //Width, height of panel is called
        graphics = image.getGraphics();
        draw(graphics); //Draw components
        g.drawImage(image,0,0,this);


    }
    public void draw (Graphics g) {

    }
    public void move() {

    }
    public void checkCollision() {

    }
    public void run() {
        //game loop
        // 60 frames
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
                System.out.println("TEST");
            }
        }

    }
    public class Ltener extends KeyAdapter { //Action Listener
        public void keyPressed(KeyEvent e) {

        }
        public void keyReleased(KeyEvent e) {

        }
    }
}
