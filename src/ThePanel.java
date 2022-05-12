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
    static final int PADDLE_HEIGHT = 90; //Paddle Height

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
        //random = new Random();
        ball = new TheBall((GAME_WIDTH/2) - (BALL_DIAMETER/2), (GAME_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);
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
        paddle1.draw(g); //Draw-up Player1 Paddle; Blue
        paddle2.draw(g); //Draw-up Player2 Paddle; Red
        ball.draw(g); //Draw up Ball
    }
    public void move() {
        // Move Paddle more smoothly across screen
        paddle1.move();
        paddle2.move();
        ball.move();
        // Move Ball more smoothly across screen
    }
    public void checkCollision() {

        // Ball will bounce off of top edge
        // Ball goes opposite when hitting edges on Top
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }

        // Ball will bounce off of bottom edge
        // Ball goes opposite when hitting edges on Bottom
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        // Bounce Ball off Paddles
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            // Increase Ball Velocity for X-Direction when Ball hits Paddle
            ball.xVelocity++;

            //Increase Ball Velocity for Y-Direction when Ball hits Paddle
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        //Stop paddles when touches edges of Application on TOP
        if (paddle1.y <= 0)
            paddle1.y = 0;
        //Stop paddles when touches border of Application on BOTTOM
        if (paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;

        //Stop paddles when touches border of Application for Player 2
        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;

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
    // Class KeyEvent
    // Action Listener for when a key is pressed and released
    public class Ltener extends KeyAdapter { //Action Listener
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
