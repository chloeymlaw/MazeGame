package compproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author chloelaw
 */

// Creating a new class
public class LoginPage {

    // Declaring a stage 
    private Stage userStage = new Stage();

    // Declaring a public void method 
    public void showLoginPage() {

        /* Defining a gridpane which will be used to display the 
        labels and buttons */
        GridPane root = new GridPane();

        final int numCols = 3;
        final int numRows = 10;

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
        };

        // Allowing the window to be seen by the user
        Scene scene = new Scene(root, 1200, 700);
        userStage.setScene(scene);
        userStage.show();

        //Calling the 'UserData' class
        UserData createNewUser = new UserData();

        Label title = new Label("Login Page");
        title.setFont(new Font("Arial", 40));

        Label username = new Label("Username");
        username.setFont(new Font("Arial", 35));
        TextField enterUsername = new TextField("c");

        Label passWord = new Label("Password");
        passWord.setFont(new Font("Arial", 35));
        PasswordField enterPassword = new PasswordField();

        /*This button will close the LoginPage and open the 
        main screen (CompProject) again */
        Button back = new Button("Back to title screen");
        back.setFont(new Font("Arial", 25));
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CompProject titleScreen = new CompProject();
                titleScreen.start(new Stage());
                userStage.close();
            }
        });

        /* This button allows the user to log in their details and if 
        it is correct, they will be taken to the next screen. If they 
        are wrong, an alert will appear telling them to try again */
        Button login = new Button("Login");
        login.setFont(new Font("Arial", 30));
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String[] userData;
                String name;
                String password;
                userData = createNewUser.getUserData(enterUsername.getText(), enterPassword.getText());
                if (userData[0] != null) {
                    name = userData[0];
                    password = userData[1];
                    IntroPage introPage = new IntroPage();
                    introPage.showIntroductionPage();
                    userStage.close();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    String s2 = "Wrong user details!\nTry again";
                    alert.setContentText(s2);
                    alert.show();
                }
            }
        });

        /* This button will allow the user to create a new user and an
        alert will appear once they have created one */
        Button newUser = new Button("Create new user");
        newUser.setFont(new Font("Arial", 30));
        newUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createNewUser.createUserData(enterUsername.getText(), enterPassword.getText());
                Alert alert = new Alert(AlertType.INFORMATION);
                String s = "User created!";
                alert.setContentText(s);
                alert.show();
            }
        });

        //Adding all the labels and buttons onto the window
        root.add(title, 1, 1);
        root.add(username, 0, 3);
        root.add(enterUsername, 1, 3);
        root.add(passWord, 0, 4);
        root.add(enterPassword, 1, 4);
        root.add(newUser, 1, 5);
        root.add(back, 0, 9);
        root.add(login, 1, 6);
    }
}
