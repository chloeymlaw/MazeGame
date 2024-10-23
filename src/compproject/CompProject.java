package compproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 *
 * @author chloelaw
 */
// Creating a class which will be the main screen
public class CompProject extends Application {

    //Opening the primary window
    public void start(Stage primaryStage) {

        /* This defines a gridpane which will be used to display the 
        labels and buttons */
        GridPane root = new GridPane();
        final int numCols = 3;
        final int numRows = 9;

        /* This will allow the columns of the screen to be split into 
        three equal columns whilst also centering the columns */
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHalignment(HPos.CENTER);
            root.getColumnConstraints().add(colConst);
        }
        
        /* This will allow the rows of the screen to be split into 
        nine equal columns */
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            root.getRowConstraints().add(rowConst);
        }

        //Declaring the scene and the size of it
        Scene scene = new Scene(root, 1200, 700);

        //Declaring the title of the window and showing the window
        primaryStage.setTitle("The Maze Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        /* Declaring all the titles and buttons which will viewed by 
        the user on this screen */
        Text title = new Text("The Maze Game");
        title.setFont(new Font("Monaco", 50));
        title.setFill(Color.WHITE);

        /* If this button is clicked on, the user will be taken to the 
        login screen where they are able to enter their details */
        Button login = new Button("Login");
        login.setFont(new Font("Monaco", 25));
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginPage loginPage = new LoginPage();
                loginPage.showLoginPage();
                primaryStage.close();
            }
        });

        /* If this button is clicked on, the user will be taken to the 
        instructions screen which will help them use this application */
        Button instruction = new Button("Instructions");
        instruction.setFont(new Font("Monaco", 25));
        instruction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InstructionsScreen instructionsScreen = new InstructionsScreen();
                instructionsScreen.showInstructionsScreen();
                primaryStage.close();
            }
        });

        // This button allows the user to exit the game 
        Button exit = new Button("Exit");
        exit.setFont(new Font("Monaco", 25));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        // Placing the buttons and labels onto the window 
        root.add(title, 1, 0);
        root.add(login, 1, 2);
        root.add(instruction, 1, 3);
        root.add(exit, 1, 4);

        //Changing the background of the window
        Image backgroundTitleScreen = new Image("titleBackground.jpg");
        BackgroundImage titleScreenImage = new BackgroundImage(backgroundTitleScreen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background firstScreen = new Background(titleScreenImage);
        root.setBackground(firstScreen);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
