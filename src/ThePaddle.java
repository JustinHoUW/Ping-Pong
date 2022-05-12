import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ThePaddle extends Rectangle {

    //Declare variables
    int id;
    int yVelocity; //How fast the paddles move in y-direction
    int speed = 10;

    ThePaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){ //Constructor
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT); //Super constructor
        this.id = id;
    }
    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
            // If pressed W
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                // If pressed S
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                // If pressed Up
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                // If pressed Down
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                // If pressed W
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                // If pressed S
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                // If pressed Up
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                // If pressed Down
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }
    public void move() {
        y = y + yVelocity;
    }
    public void draw(Graphics g) {
        if (id==1)
        g.setColor(Color.blue); //First Player is Blue
        else
            g.setColor(Color.red); //Second Player is Red
        g.fillRect(x, y, width, height);
    
    }
}
