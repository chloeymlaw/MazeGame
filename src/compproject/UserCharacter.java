package compproject;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author chloelaw
 */

//Creating a new class
public class UserCharacter {

    //This defines 2 public static integers as well as a public image
    public static int posX, posY;
    public Image playerCharacter;

    /*This declares a new public method 'UserCharacter' where the 
    user character image and x,y positions are declared*/
    public UserCharacter() {

        ImageIcon player = new ImageIcon("UserCharacter.png");

        playerCharacter = player.getImage();

        posX = 1;
        posY = 1;

    }

    //A public image is declared which returns the image of the user character
    public Image getUserCharacter() {
        return playerCharacter;
    }

    //2 public integers are declared which return the user characters position
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    //The public method 'method' adds the integers dx and dy to the users x,y positions
    public void move(int dx, int dy) {
        posX += dx;
        posY += dy;
    }
}