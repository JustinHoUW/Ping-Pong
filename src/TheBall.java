import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TheBall extends Rectangle{

    Random random;
    int xVelocity; //How fast the ball moves in the x-axis
    int yVelocity; //How fast the ball moves in the y-axis
    // Make new variable to multiply to this variable
    // For Ball to speed up across the application
    int initialSpeed = 2;

    TheBall(int x, int y, int width, int height){ //Constructor
        super(x, y, width, height);
        random = new Random(); // Random Direction Ball heading
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) // If variable = 0, Ball goes Left
            randomXDirection--; //-1; X-Direction going Left
            setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--; //-1
        setYDirection(randomYDirection * initialSpeed);

        }

    public void setXDirection (int randomXDirection) { //Ball potentially moves in any x-direction
        xVelocity = randomXDirection;
    }
    public void setYDirection (int randomYDirection) { //Ball potentially moves in any y-direction ALSO
        yVelocity = randomYDirection;
    }
    public void move() {
        x += xVelocity;
                y += yVelocity;
    }

    public void draw (Graphics g) {
        g.setColor(Color.white); //White ball like Ping-Pong ball
        g.fillOval(x,y,height,width); //Draw Circle using method
    }
}
