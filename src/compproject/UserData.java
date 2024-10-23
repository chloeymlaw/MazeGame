package compproject;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

/**
 *
 * @author chloelaw
 */

//Creating a new class
public class UserData {

    //Declaring a pulic void (method)
    public void createUserData(String username, String password) {

        /*Declaring a new string will store the username and password, 
        seperated by a comma*/
        String userData = username + "," + password;

        /*Using a try catch method to open the textfile and write data 
        (the username and password) into it. Once finished, it will go onto the
        next line and close the file*/
        try {
            BufferedWriter newUser = new BufferedWriter(new FileWriter("userDetails.txt", true));
            newUser.write(userData);
            newUser.newLine();
            newUser.flush();
            newUser.close();
        } catch (IOException x) {
            System.err.format("IOException;", x);
        }
    }

    /*Declaring another public method as a string which passes the strings 
    'username' and 'password' as parameters*/
    public String[] getUserData(String username, String password) {

        /*Declaring two new strings and a path to where the login details are 
        stored so that the user's input can be checked against*/
        String[] userData = new String[3];
        String[] textLine = new String[3];
        Path file = Paths.get("userDetails.txt");
        Charset charset = Charset.forName("US-ASCII");

        /*Using a try catch method to read the file and checking that the data 
        within the file is being separated by a comma. If this is true, this 
        will check whether the user's input is the same as in the textfile, 
        if so, a new string is declared */
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            for (String line; (line = reader.readLine()) != null;) {
                textLine = line.split(",");
                if (textLine[0].equals(username)) {
                    if (textLine[1].equals(password)) {
                        userData = textLine;
                    }
                }
            }

            //the userData string is returned
            return userData;
        } catch (IOException x) {
            System.err.format("IOEXCEPTION", x);
        }
        //the textLine string is returned
        return textLine;
    }
}
