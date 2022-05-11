import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TheFrame extends JFrame {
    ThePanel panel;

        TheFrame() { //Houses the panel
            panel = new ThePanel();
            this.add(panel);
            this.setTitle("Ping Pong Game");
            this.setResizable(false);
            this.setBackground(Color.BLACK);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when click x button
            this.pack(); //Preferred size according to it's subcomponents; panel
            this.setVisible(true); //Can actually see
            this.setLocationRelativeTo(null); //Appear in middle of screen
        }
    }

