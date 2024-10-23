package compproject;

//Importing all of the necessary classes
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author chloelaw
 */

//Creating a new class 
public class IntroPage {

    //Creating a new private stage
    private Stage introductionStage = new Stage();

    //Declaring a new public void (method)
    public void showIntroductionPage() {
        
        /* Defining a gridpane which will be used to display the 
        labels and buttons */
        GridPane root = new GridPane();

        Scene scene = new Scene(root, 1200, 650);
        introductionStage.setScene(scene);
        introductionStage.show();

        final int numCols = 3;
        final int numRows = 5;

        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHalignment(HPos.CENTER);
            root.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            root.getRowConstraints().add(rowConst);
        }

        Label welcome = new Label("Welcome to the Maze Game!");
        welcome.setFont(new Font("Arial", 30));

        Label chooseLevel = new Label("Select a level");
        chooseLevel.setFont(new Font("Arial", 25));

        /* Once this button is selected it, it will take the user to 
        the easy level */
        Button easyMode = new Button("Easy Level");
        easyMode.setFont(new Font("Arial", 25));
        easyMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MazeEasy easyMaze = new MazeEasy();
                introductionStage.close();
            }
        });
        
        /* Once this button is selected it, it will take the user to 
        the hard level */
        Button hardMode = new Button("Hard Level");
        hardMode.setFont(new Font("Arial", 25));
        hardMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MazeHard hardMaze = new MazeHard();
                introductionStage.close();
            }
        });

        root.add(welcome, 1, 0);
        root.add(chooseLevel, 1, 1);
        root.add(easyMode, 0, 2);
        root.add(hardMode, 2, 2);

    }
}
