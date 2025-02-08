package mx.edu.greengates.cs.tutorial.beto;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class ReportApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
         //name and passwords
        HBox namePane = new HBox(5);
        TextField nameField = new TextField();
        namePane.getChildren().add(new Label("Name:"));
        namePane.getChildren().add(nameField);


        HBox surnamePane = new HBox(5);
        TextField surnameField = new TextField();
        surnamePane.getChildren().add(new Label("Surname:"));
        surnamePane.getChildren().add(surnameField);


        VBox layout = new VBox(5);
        layout.getChildren().add(new Label("Enter your credentials:"));
        layout.getChildren().add(namePane);
        layout.getChildren().add(surnamePane);




        // radio button
        Label pregnantLabel = new Label("Pregnant:");
        RadioButton noButton = new RadioButton("No");
        RadioButton yesButton = new RadioButton("Yes");
        ToggleGroup pregnantGroup = new ToggleGroup();
        noButton.setToggleGroup(pregnantGroup);
        yesButton.setToggleGroup(pregnantGroup);
        HBox pregnantPane = new HBox(10);
        pregnantPane.getChildren().addAll(noButton, yesButton);
        layout.getChildren().add(pregnantLabel);
        layout.getChildren().add(pregnantPane);



        // checkbox for appointment days
        Label appointmentLabel = new Label("Appointment:");
        CheckBox mondayCheckBox = new CheckBox("Monday");
        CheckBox tuesdayCheckBox = new CheckBox("Tuesday");
        CheckBox wednesdayCheckBox = new CheckBox("Wednesday");
        CheckBox thursdayCheckBox = new CheckBox("Thursday");
        CheckBox fridayCheckBox = new CheckBox("Friday");
        CheckBox saturdayCheckBox = new CheckBox("Saturday");
        CheckBox sundayCheckBox = new CheckBox("Sunday");
        HBox appointmentPane = new HBox(10);
        appointmentPane.getChildren().addAll(mondayCheckBox, tuesdayCheckBox, wednesdayCheckBox, thursdayCheckBox, fridayCheckBox, saturdayCheckBox, sundayCheckBox);
        layout.getChildren().add(appointmentLabel);
        layout.getChildren().add(appointmentPane);


        // combobox for needs
        Label needsLabel = new Label("Select your needs:");
        ComboBox<String> needsComboBox = new ComboBox<>();
        needsComboBox.getItems().addAll("Counseling", "Medical", "Shelter");
        needsComboBox.setPromptText("Select a need");

        layout.getChildren().add(needsLabel);
        layout.getChildren().add(needsComboBox);




        //  Register button
        Button RegisterButton = new Button("Register");




        // get info
        RegisterButton.setOnAction(e -> {
            String name = nameField.getText();

            String surname = surnameField.getText();

            RadioButton selectedPregnant = (RadioButton) pregnantGroup.getSelectedToggle();
            String pregnantStatus = selectedPregnant != null ? selectedPregnant.getText() : "No answer";

            String selectedNeed = needsComboBox.getValue() != null ? needsComboBox.getValue() : "No need selected";

            StringBuilder Appointments = new StringBuilder();
            if (mondayCheckBox.isSelected()) {
                Appointments.append("Monday ");
            }
            if (tuesdayCheckBox.isSelected()) {
                Appointments.append("Tuesday ");
            }
            if (wednesdayCheckBox.isSelected()) {
                Appointments.append("Wednesday ");
            }
            if (thursdayCheckBox.isSelected()) {
                Appointments.append("Thursday ");
            }
            if (fridayCheckBox.isSelected()) {
                Appointments.append("Friday ");
            }
            if (saturdayCheckBox.isSelected()) {
                Appointments.append("Saturday ");
            }
            if (sundayCheckBox.isSelected()) {
                Appointments.append("Sunday ");
            }


            // print out results
            System.out.println("Name: " + name);
            System.out.println("Surname: " + surname);
            System.out.println("Pregnant: " + pregnantStatus);
            System.out.println("Selected need: " + selectedNeed);
        });




        // Login button
        layout.getChildren().add(RegisterButton);




        // Create the scene and set the stage
        Scene scene = new Scene(layout, 700, 600);
        stage.setTitle("User Form");
        stage.setScene(scene);
        stage.show();
    }
}
