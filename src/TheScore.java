import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TheScore extends Rectangle{

    // Declare variables
    static int GAME_WIDTH; //Game width already initialized
    static int GAME_HEIGHT; //Game height already initialized
    int player1; //Current Score of Player 1
    int player2; //Current Score of Player 2

    TheScore(int GAME_WIDTH, int GAME_HEIGHT){ //Constructor
        TheScore.GAME_WIDTH = GAME_WIDTH;
        TheScore.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw (Graphics g) {//Draw score, counting
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.BOLD,60));

        g.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT); //White line through middle

        // Draw Scoreboard
        // Both players start at 00
        g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10),(GAME_WIDTH/2)-85, 50);
        g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10),(GAME_WIDTH/2)+5, 50);

    }
}
