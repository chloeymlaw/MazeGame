package compproject;

import javax.swing.JFrame;

/**
 *
 * @author chloelaw
 */

//Creating a new class
public class MazeEasy {

    /*Creating a new method where the JFrame is declared and the size of the window. The location is set 
    to null so that it is in the centre of the screen. */
    public MazeEasy() {
        JFrame frame = new JFrame();
        frame.setTitle("Maze Game: Easy Level");
        frame.add(new Board());
        frame.setSize(1495, 840);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
