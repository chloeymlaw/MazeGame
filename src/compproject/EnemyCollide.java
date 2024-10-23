package compproject;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author chloelaw
 */

public class EnemyCollide {

    /*Creating a new method where the JFrame is declared and the size of the window. The location is set to 
    null so that it appears in the middle of the screen. A JLabel will appear to inform the user 
    that they have been killed by the enemy. Once this window is shut, the whole progarm closes*/
    public EnemyCollide() {
        JFrame collision = new JFrame();
        collision.setSize(650, 300);
        collision.setLocationRelativeTo(null);
        collision.setVisible(true);
        JLabel collided = new JLabel("Oh no! You were killed by the enemy! Press the exit button in the corner to quit", JLabel.CENTER);
        collided.setFont(new Font("Arial", Font.PLAIN, 18));
        collision.add(collided);
        collision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}