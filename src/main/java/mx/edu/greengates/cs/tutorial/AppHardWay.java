package mx.edu.greengates.cs.tutorial;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppHardWay extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        HBox namePane = new HBox(5);
        namePane.getChildren().add(new Label("Name:"));
        namePane.getChildren().add(new TextField());

        HBox passwordPane = new HBox(5);
        passwordPane.getChildren().add(new Label("Password:"));
        passwordPane.getChildren().add(new PasswordField());

        VBox layout = new VBox(5);
        layout.getChildren().add(new Label("Please enter your credentials:"));
        layout.getChildren().add(new CheckBox("Remember me"));
        layout.getChildren().add(new Button("Login"));
        layout.getChildren().add(namePane);
        layout.getChildren().add(passwordPane);

        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}
