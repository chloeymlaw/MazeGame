package compproject;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author chloelaw
 */

public class EndScreen {

    /*Creating a new method where the JFrame is declared, along with the size of window.
    The location is set to null so it is centred in the middle of the screen. A JLabel 
    is also displayed which congratulates the user on completing the maze game. 
    Once this window is closed, the whole program will end*/
    public EndScreen() {
        JFrame end = new JFrame();
        end.setSize(650, 300);
        end.setLocationRelativeTo(null);
        end.setVisible(true);
        JLabel wellDone = new JLabel("Congratulations, you win! Press the exit button in the corner to quit", JLabel.CENTER);
        wellDone.setFont(new Font("Arial", Font.PLAIN, 21));
        end.add(wellDone);
        end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}