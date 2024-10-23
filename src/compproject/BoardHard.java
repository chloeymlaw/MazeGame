package compproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author chloelaw
 */

public class BoardHard extends JPanel implements ActionListener, KeyListener {

    //Declaring a new timer as well as calling the 'Map', 'UserCharacter' and 'EnemyCharacter' class
    private Timer timer;
    private MapHard mHard;
    private UserCharacter pHard;
    private EnemyCharacter eHard;
    private EnemyCharacter eHard2;
    private EnemyCharacter eHard3;
    private EnemyCharacter eHard4;

    /*Declaring a method for when keys are pressed.
    So if WASD or the arrow keys are pressed, the program will respond to what it has been coded 
    to say and if there is a wall, the user cannot move in that direction*/
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_W) {
            if (!mHard.mapHardGet(pHard.getPosX(), pHard.getPosY() - 1).equals("w")) {
                pHard.move(0, -1);
            }
        }
        if (keycode == KeyEvent.VK_W) {
            if (mHard.mapHardGet(pHard.getPosX(), pHard.getPosY() + 1).equals("e")) {
                pHard.move(0, 0);
                EndScreen endScreenHard = new EndScreen();
            }
        }
        if (keycode == KeyEvent.VK_A) {
            if (!mHard.mapHardGet(pHard.getPosX() - 1, pHard.getPosY()).equals("w")) {
                pHard.move(-1, 0);
            }
        }
        if (keycode == KeyEvent.VK_S) {
            if (!mHard.mapHardGet(pHard.getPosX(), pHard.getPosY() + 1).equals("w")) {
                pHard.move(0, 1);
            }
        }
        if (keycode == KeyEvent.VK_D) {
            if (!mHard.mapHardGet(pHard.getPosX() + 1, pHard.getPosY()).equals("w")) {
                pHard.move(1, 0);
            }
        }
        if (keycode == KeyEvent.VK_UP) {
            if (!mHard.mapHardGet(pHard.getPosX(), pHard.getPosY() - 1).equals("w")) {
                pHard.move(0, -1);
            }
        }
        if (keycode == KeyEvent.VK_UP) {
            if (mHard.mapHardGet(pHard.getPosX(), pHard.getPosY()).equals("e")) {
                pHard.move(0, 0);
                EndScreen endScreenHard = new EndScreen();
            }
        }
        if (keycode == KeyEvent.VK_LEFT) {
            if (!mHard.mapHardGet(pHard.getPosX() - 1, pHard.getPosY()).equals("w")) {
                pHard.move(-1, 0);
            }
        }
        if (keycode == KeyEvent.VK_DOWN) {
            if (!mHard.mapHardGet(pHard.getPosX(), pHard.getPosY() + 1).equals("w")) {
                pHard.move(0, 1);
            }
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            if (!mHard.mapHardGet(pHard.getPosX() + 1, pHard.getPosY()).equals("w")) {
                pHard.move(1, 0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    /*Declaring a new public method.
    The classes 'Map', 'UserCharacter' and 'EnemyCharacter' are declared. 
    The countdown timer class is also called. The enemy character has parameters passing 
    by value so it is in a particular position. The timer is added to control how 
    often the repaint function occurs.*/
    public BoardHard() {
        mHard = new MapHard();
        pHard = new UserCharacter();
        eHard = new EnemyCharacter(16, 12);
        eHard2 = new EnemyCharacter(27, 18);
        eHard3 = new EnemyCharacter(24, 3);
        eHard4 = new EnemyCharacter(5, 2);

        timer = new Timer(270, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new timerCountdown(), 0, 1000);

    }

    /*Everytime the timer gets to 350, the action listener detects 
    and calls the repaint function*/
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /*This method allows the maze to be painted according to the map.txt file 
    and the enemies and the user character according to their .png file*/
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 37; x++) {
                if (mHard.mapHardGet(x, y).equals("w")) {
                    g.drawImage(mHard.getWall(), x * 40, y * 40, null);
                }
                if (mHard.mapHardGet(x, y).equals("b")) {
                    g.drawImage(mHard.getBackground(), x * 40, y * 40, null);
                }
                if (mHard.mapHardGet(x, y).equals("e")) {
                    g.drawImage(mHard.getEndPoint(), x * 40, y * 40, null);
                }
            }
        }
        g.drawImage(pHard.getUserCharacter(), pHard.getPosX() * 40, pHard.getPosY() * 40, null);
        eHard.EnemyRandomMovement(chasingEnemy());
        eHard.EnemyRandomMovement(RandomMoveEnemyHard());
        eHard2.EnemyRandomMovement(RandomMoveEnemyHard());
        eHard3.EnemyRandomMovement(RandomMoveEnemyHard());
        eHard4.EnemyRandomMovement(RandomMoveEnemyHard());
        g.drawImage(eHard.getEnemyCharacter(), eHard.getEnemyPosX() * 40, eHard.getEnemyPosY() * 40, null);
        g.drawImage(eHard2.getEnemyCharacter(), eHard2.getEnemyPosX() * 40, eHard2.getEnemyPosY() * 40, null);
        g.drawImage(eHard3.getEnemyCharacter(), eHard3.getEnemyPosX() * 40, eHard3.getEnemyPosY() * 40, null);
        g.drawImage(eHard4.getEnemyCharacter(), eHard4.getEnemyPosX() * 40, eHard4.getEnemyPosY() * 40, null);
    }

    /*This is a public string allows for the int 'goToUser' be equal to one. If the user's x position
    is less than the enemy's x position, then the 'goToUser' integer will change to one which triggers
    case 1 to be executed. This will be applied if the 'goToUser' is equal to two and so on */
    public String chasingEnemy() {
        int goToUser = 0;
        if (pHard.getPosX() < eHard.getEnemyPosX()) {
            goToUser = 1;
        }
        if (pHard.getPosX() > eHard.getEnemyPosX()) {
            goToUser = 2;
        }
        if (pHard.getPosY() < eHard.getEnemyPosY()) {
            goToUser = 3;
        }
        if (pHard.getPosY() > eHard.getEnemyPosY()) {
            goToUser = 4;
        }

        switch (goToUser) {
            case 1:
                return "LeftHard";
            case 2:
                return "RightHard";
            case 3:
                return "UpHard";
            case 4:
                return "DownHard";    
        }
        return "";
    }

    /*This is a public string where the integer 'randomDirection' is used to randomly 
    select one of the cases in the code which makes the enemy move in different directions*/
    public String RandomMoveEnemyHard() {
        int randomDirection = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        switch (randomDirection) {
            case 1:
                return "UpHard";
            case 2:
                return "DownHard";
            case 3:
                return "LeftHard";
            case 4:
                return "RightHard";
        }
        return "";
    }
}