package compproject;

import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author chloelaw
 */

//Creating a new class which is a JPanel and implements an action and keylistener
public class Board extends JPanel implements ActionListener, KeyListener {

    //Declaring a new timer as well as calling the 'Map', 'UserCharacter' and 'EnemyCharacter' class
    private Timer timer;
    private Map m;
    private UserCharacter p;
    private EnemyCharacter e;
    private EnemyCharacter e2;
    private EnemyCharacter e3;

    /*Declaring a method for when keys are pressed.
    So if WASD or the arrow keys are pressed, the program will respond to what it has been coded 
    to say and if there is a wall, the user cannot move in that direction*/
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_W) {
            if (!m.mapGet(p.getPosX(), p.getPosY() - 1).equals("w")) {
                p.move(0, -1);
            }
        }
        if (keycode == KeyEvent.VK_W) {
            if (m.mapGet(p.getPosX(), p.getPosY()).equals("e")) {
                p.move(0, 1);
                EndScreen endScreen = new EndScreen();
            }
        }
        if (keycode == KeyEvent.VK_A) {
            if (!m.mapGet(p.getPosX() - 1, p.getPosY()).equals("w")) {
                p.move(-1, 0);
            }
        }
        if (keycode == KeyEvent.VK_S) {
            if (!m.mapGet(p.getPosX(), p.getPosY() + 1).equals("w")) {
                p.move(0, 1);
            }
        }
        if (keycode == KeyEvent.VK_D) {
            if (!m.mapGet(p.getPosX() + 1, p.getPosY()).equals("w")) {
                p.move(1, 0);
            }
        }
        if (keycode == KeyEvent.VK_UP) {
            if (!m.mapGet(p.getPosX(), p.getPosY() - 1).equals("w")) {
                p.move(0, -1);
            }
        }
        if (keycode == KeyEvent.VK_UP) {
            if (m.mapGet(p.getPosX(), p.getPosY()).equals("e")) {
                p.move(0, 1);
                EndScreen endScreen = new EndScreen();
            }
        }
        if (keycode == KeyEvent.VK_LEFT) {
            if (!m.mapGet(p.getPosX() - 1, p.getPosY()).equals("w")) {
                p.move(-1, 0);
            }
        }
        if (keycode == KeyEvent.VK_DOWN) {
            if (!m.mapGet(p.getPosX(), p.getPosY() + 1).equals("w")) {
                p.move(0, 1);
            }
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            if (!m.mapGet(p.getPosX() + 1, p.getPosY()).equals("w")) {
                p.move(1, 0);
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
    public Board() {

        m = new Map();
        p = new UserCharacter();
        e = new EnemyCharacter(18, 12);
        e2 = new EnemyCharacter(5, 16);
        e3 = new EnemyCharacter(28, 3);

        timer = new Timer(350, this);
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
                if (m.mapGet(x, y).equals("w")) {
                    g.drawImage(m.getWall(), x * 40, y * 40, null);
                }
                if (m.mapGet(x, y).equals("b")) {
                    g.drawImage(m.getBackground(), x * 40, y * 40, null);
                }
                if (m.mapGet(x, y).equals("e")) {
                    g.drawImage(m.getEndPoint(), x * 40, y * 40, null);
                }
            }
        }
        e.EnemyRandomMovement(RandomMoveEnemy());
        e2.EnemyRandomMovement(RandomMoveEnemy());
        e3.EnemyRandomMovement(RandomMoveEnemy());
        g.drawImage(p.getUserCharacter(), p.getPosX() * 40, p.getPosY() * 40, null);
        g.drawImage(e.getEnemyCharacter(), e.getEnemyPosX() * 40, e.getEnemyPosY() * 40, null);
        g.drawImage(e2.getEnemyCharacter(), e2.getEnemyPosX() * 40, e2.getEnemyPosY() * 40, null);
        g.drawImage(e3.getEnemyCharacter(), e3.getEnemyPosX() * 40, e3.getEnemyPosY() * 40, null);
    }

    //This is a public string so that the enemy can move in random directions
    public String RandomMoveEnemy() {
        int randomDirection = ThreadLocalRandom.current().nextInt(1, 7 + 1);

        switch (randomDirection) {
            case 1:
                return "Up";
            case 2:
                return "Down";
            case 3:
                return "Left";
            case 4:
                return "Right";
        }
        return "";
    }
}

/*This is a class which counts down from 100 and once it reaches zero, it 
displays the TimerEnd class to show that time is up to the user*/
class timerCountdown extends TimerTask {

    int countdown = 100;

    public void run() {
        countdown = countdown - 1;
        if (countdown <= 0) {
            cancel();
            TimerEnd timerEnd = new TimerEnd();
        }
    }
}