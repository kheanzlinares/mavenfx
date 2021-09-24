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
        button.setVisible(false);

        StringProperty passwordFieldProperty = passwordField.textProperty();

        //visiblePassword.textProperty().bind(passwordFieldProperty);

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
}
