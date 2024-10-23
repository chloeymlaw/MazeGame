 package compproject;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author chloelaw
 */

public class TimerEnd {
    
    /*Creating a new method where the JFrame is declared and the size of the window. The location is 
    null so that it appears in the middle of the screen. 
    If the user runs out of time, the label will be displayed within the window. When this window is closed, 
    the whole program will end.*/
    public TimerEnd() {
        JFrame timerEnd = new JFrame();
        timerEnd.setSize(650, 300);
        timerEnd.setLocationRelativeTo(null);
        timerEnd.setVisible(true);
        JLabel timesUp = new JLabel("Oh no! You ran out of time! Press the exit button in the corner to quit", JLabel.CENTER);
        timesUp.setFont(new Font("Arial", Font.PLAIN, 20));
        timerEnd.add(timesUp);
        timerEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}