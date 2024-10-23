package compproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;

/**
 *
 * @author chloelaw
 */
//Declaring a new class
public class InstructionsScreen {

    //Decalring a private stage
    private Stage instructionsScreen = new Stage();

    //Declaring a public void (method)
    public void showInstructionsScreen() {

        //Defining a gridpane along with the number of columns and rows
        GridPane root = new GridPane();

        final int numCols = 1;
        final int numRows = 7;

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

        Scene scene = new Scene(root, 1600, 700);
        instructionsScreen.setScene(scene);
        instructionsScreen.show();

        Label title = new Label("Instructions");
        title.setFont(new Font("Arial", 50));

        Label instructions = new Label("To start the game, go on the login screen and enter your login details");
        instructions.setFont(new Font("Arial", 30));

        Label instructions2 = new Label("How to move: W = Up, A = Left, S = Down and D = Right");
        instructions2.setFont(new Font("Arial", 30));

        Label instructions3 = new Label("Alternatively, you can use your arrow keys.");
        instructions3.setFont(new Font("Arial", 30));

        Label instructions4 = new Label("Your goal is to reach the end point (red point) in the maze within 100 seconds whilst avoiding the enemies!");
        instructions4.setFont(new Font("Arial", 30));

        //This button allows the user to go back to the title screen once they have read the instructions
        Button back = new Button("Back to title screen");
        back.setFont(new Font("Arial", 30));
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CompProject titleScreen = new CompProject();
                titleScreen.start(new Stage());
                instructionsScreen.close();
            }
        });

        root.add(title, 0, 0);
        root.add(instructions, 0, 1);
        root.add(instructions2, 0, 2);
        root.add(instructions3, 0, 3);
        root.add(instructions4, 0, 4);
        root.add(back, 0, 5);

    }
}
