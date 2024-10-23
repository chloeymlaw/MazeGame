package compproject;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 *
 * @author chloelaw
 */

public class MapHard {

    /*Declaring a private scanner 'mazeMapHard' and a public string 'MapHard'. Three private
    images are also declared which represnt the walls, background and end point*/
    private Scanner mazeMapHard;
    public String MapHard[] = new String[37];
    private Image border;
    private Image back;
    private Image end;

    /*Declares new public method where all the images are defined and methods 
    'openFile', 'readFile' and 'closeFile' are called*/
    public MapHard() {

        ImageIcon wall = new ImageIcon("wall.png");
        border = wall.getImage();

        ImageIcon background = new ImageIcon("background.png");
        back = background.getImage();

        ImageIcon endPoint = new ImageIcon("endPoint.png");
        end = endPoint.getImage();

        openFile();
        readFile();
        closeFile();
    }

    //Three public images are declared which return the corresponding image
    public Image getWall() {
        return border;
    }

    public Image getBackground() {
        return back;
    }

    public Image getEndPoint() {
        return end;
    }

    /*This ccontains a string called index which is responsible for going through 
    all the x and y positions. It will go through all the values in each row 
    until it reaches the final row*/
    public String mapHardGet(int x, int y) {
        String index = MapHard[y].substring(x, x + 1);
        return index;
    }

    /*This method uses a try catch method to scan the file which will be 
    used to create the backgrounds and walls*/
    public void openFile() {

        try {
            mazeMapHard = new Scanner(new File("mapHard.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*The public method uses a try catch method to ensure the .txt file 
    has 36 letters to represnt the board*/
    public void readFile() {
        try {
            while (mazeMapHard.hasNext()) {
                for (int i = 0; i < 37; i++) {
                    MapHard[i] = mazeMapHard.next();
                }

            }
        } catch (Exception e) {

        }
    }

    //This publid method is responsible for closing the map file
    public void closeFile() {
        try {
            mazeMapHard.close();
        } catch (Exception e) {

        }
    }
}