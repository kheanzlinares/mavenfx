package nl.inholland.javafx;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    Label userLabel, passwordLabel;
    TextField userInput;
    PasswordField passwordField;
    Button button;

    @Override
    public void start(Stage window) throws Exception{
        window.setHeight(200);
        window.setWidth(320);
        window.setTitle("Login Window");

        userLabel = new Label("username");
        passwordLabel = new Label("password");
        userInput = new TextField();
        userInput.setPromptText("username");
        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        button = new Button("Log in");

        button.setDisable(true);

        if(isValid(passwordField)){
            button.setDisable(false);
        }

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(8);
        gridPane.setVgap(10);

        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(userInput, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(button, 1, 2);

        gridPane.getChildren().addAll(userLabel, userInput, passwordLabel, passwordField, button);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.show();

    }

    public static boolean isValid (PasswordField password){
        //checking for password length

        if(!(password.getText().length() >= 8)){
            return false;
        }
        if (!(password.getText().contains("@")|| password.getText().contains("#")
                || password.getText().contains("!") || password.getText().contains("~")
                || password.getText().contains("$") || password.getText().contains("%")
                || password.getText().contains("^") || password.getText().contains("&")
                || password.getText().contains("*") || password.getText().contains("(")
                || password.getText().contains(")") || password.getText().contains("-")
                || password.getText().contains("+") || password.getText().contains("/")
                || password.getText().contains(":") || password.getText().contains(".")
                || password.getText().contains(", ") || password.getText().contains("<")
                || password.getText().contains(">") || password.getText().contains("?")
                || password.getText().contains("|"))) {
            return false;
        }

        if(true){
            int count = 0;

            for (int i = 65; i <= 122; i++) {

                // type casting
                char c = (char)i;

                String alphabet = Character.toString(c);
                if (password.getText().contains(alphabet)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }

        if (true) {
            int count = 0;

            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {

                // to convert int to string
                String numbers = Integer.toString(i);

                if (password.getText().contains(numbers)) {
                    count = 1;
                }
            }

            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}
