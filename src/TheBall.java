import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TheBall extends Rectangle{

    Random random;
    int xVelocity; //How fast the ball moves in the x-axis
    int yVelocity; //How fast the ball moves in the y-axis

    TheBall(int x, int y, int width, int height){ //Constructor
        super(x, y, width, height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) {
            randomXDirection--; //-1
            setXDir(randomXDirection);

        }
    }
    public void setXDir (int randomXDir) { //Ball potentially moves in any x-direction

    }
    public void setYDir (int randomYDir) { //Ball potentially moves in any y-direction ALSO

    }
    public void move() {

    }
    public void draw (Graphics g) {

    }
}
