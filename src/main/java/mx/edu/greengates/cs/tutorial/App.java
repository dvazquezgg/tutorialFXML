package mx.edu.greengates.cs.tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file "welcome.fxml"
        FXMLLoader loader = new FXMLLoader(App.class.getResource("welcome.fxml"));

        // Load a controller instance for the FXML file
        //loader.setController(new WelcomeController());

        // Create a scene with the loaded layout and set its dimensions
        Scene scene = new Scene(loader.load());

        // Set up the primary stage (window) of the application
        stage.setTitle("Welcome!");
        // Set the scene to the stage
        stage.setScene(scene);
        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
