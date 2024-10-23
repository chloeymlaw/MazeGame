package compproject;

import java.awt.Image;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.io.File;

/**
 *
 * @author chloelaw
 */

//Declaring a new class
public class Map {

    /*Declaring a private scanner 'MazeMap' and a public string 'Map'. Three private
    images are also declared which represnt the walls, background and end point*/
    private Scanner mazeMap;
    public String Map[] = new String[37];
    private Image border;
    private Image back;
    private Image end;
 
    /*Declares new public method where all the images are defined and methods 
    'openFile', 'readFile' and 'closeFile' are called*/
    public Map() {

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
    public String mapGet(int x, int y) {
        String index = Map[y].substring(x, x + 1);
        return index;
    }

    /*This method uses a try catch method to scan the file which will be 
    used to create the backgrounds and walls*/
    public void openFile() {

        try {
            mazeMap = new Scanner(new File("map.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*The public method uses a try catch method to ensure the .txt file 
    has 36 letters to represnt the board*/
    public void readFile() {
        try {
            while (mazeMap.hasNext()) {
                for (int i = 0; i < 37; i++) {
                    Map[i] = mazeMap.next();
                }

            }
        } catch (Exception e) {

        }
    }

    //This publid method is responsible for closing the map file
    public void closeFile() {
        try {
            mazeMap.close();
        } catch (Exception e) {

        }
    }
}
