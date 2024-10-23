package compproject;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author chloelaw
 */

public class EnemyCharacter {

    /*A private image, integer and string are defined and 
    the 'Map', 'MapHard' classes are called*/
    private Image enemy;
    private int enemyPosX, enemyPosY;
    private String move = "";
    private Map m;
    private MapHard mHard;
    
    /*This method gets the enemy's icone which will be shown on the screen and the 
    'Map' and 'MapHard' classes are declared. The enemy's x,y position are also 
    declared as the parameter that is passed by value*/
    public EnemyCharacter(int enemyX, int enemyY) {

        ImageIcon characterEnemy = new ImageIcon("EnemyCharacter.png");
        enemy = characterEnemy.getImage();

        enemyPosX = enemyX;
        enemyPosY = enemyY;

        m = new Map();
        mHard = new MapHard();

    }

    //A public image is declared which returns the image of the enemy
    public Image getEnemyCharacter() {
        return enemy;
    }

    //2 public integers are declared which return the x and y positions of
    //the enemy
    public int getEnemyPosX() {
        return enemyPosX;
    }

    public int getEnemyPosY() {
        return enemyPosY;
    }

    /*This public method passes the string 'moveEnemy' from the 'Board' class by value. #
    Allows for the enemy to move depending on the code and if there is a wall then the enemy
    will not be able to move in that direction*/
    public void EnemyRandomMovement(String moveEnemy) {
        move = moveEnemy;

        if (move == "Up") {
            if (!m.mapGet(this.getEnemyPosX(), this.getEnemyPosY() - 1).equals("w")) {
                this.enemyMove(0, -1);
            }
        }
        if (move == "Down") {
            if (!m.mapGet(this.getEnemyPosX(), this.getEnemyPosY() + 1).equals("w")) {
                this.enemyMove(0, 1);
            }
        }
        if (move == "Left") {
            if (!m.mapGet(this.getEnemyPosX() - 1, this.getEnemyPosY()).equals("w")) {
                this.enemyMove(-1, 0);
            }
        }
        if (move == "Right") {
            if (!m.mapGet(this.getEnemyPosX() + 1, this.getEnemyPosY()).equals("w")) {
                this.enemyMove(1, 0);
            }
        }
        if (move == "UpHard") {
            if (!mHard.mapHardGet(this.getEnemyPosX(), this.getEnemyPosY() - 1).equals("w")) {
                this.enemyMove(0, -1);
            }
        }
        if (move == "DownHard") {
            if (!mHard.mapHardGet(this.getEnemyPosX(), this.getEnemyPosY() + 1).equals("w")) {
                this.enemyMove(0, 1);
            }
        }
        if (move == "LeftHard") {
            if (!mHard.mapHardGet(this.getEnemyPosX() - 1, this.getEnemyPosY()).equals("w")) {
                this.enemyMove(-1, 0);
            }
        }
        if (move == "RightHard") {
            if (!mHard.mapHardGet(this.getEnemyPosX() + 1, this.getEnemyPosY()).equals("w")) {
                this.enemyMove(1, 0);
            }
        }
    }

    //This is a public method which adds the integers dx and dy to the enemy's x and y positions
    public void enemyMove(int dx, int dy) {
        checkIfCollided();
        enemyPosX += dx;
        enemyPosY += dy;
    }

    /*This is a public method which checks to see if the position of the user character is the same 
    as the position of the enemy character. If that is the case, then the 
    'EnemyCollide' class is called and displayed. */
    public void checkIfCollided() {
        if ((UserCharacter.posX == enemyPosX) && (UserCharacter.posY == enemyPosY)) {
            EnemyCollide enemyCollide = new EnemyCollide();
        }
    }
}