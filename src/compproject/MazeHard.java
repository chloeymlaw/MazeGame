package compproject;

import javax.swing.JFrame;

/**
 *
 * @author chloelaw
 */

public class MazeHard {
 
    /*Creating a new method where the JFrame is declared and the size of the window. The location is set 
    to null so that it is in the centre of the screen. */
    public MazeHard() {
        JFrame frameHard = new JFrame();
        frameHard.setTitle("Maze Game: Hard Level");
        frameHard.add(new BoardHard());
        frameHard.setSize(1495, 840);
        frameHard.setLocationRelativeTo(null);
        frameHard.setVisible(true);
    }
}