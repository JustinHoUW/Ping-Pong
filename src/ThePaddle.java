import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ThePaddle extends Rectangle {

    //Declare variables
    int id;
    int yVelocity; //How fast the paddles move in y-direction

    ThePaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){ //Constructor
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT); //Super constructor
        this.id = id;
    }
    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
    public void setYDirection(int yDirection) {

    }
    public void move() {

    }
    public void draw(Graphics g) {
    
    }
}
