package mx.edu.greengates.cs.tutorial.val;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.edu.greengates.cs.tutorial.Storage;

public class AppHardWay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        HBox namePane = new HBox(5);
        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        namePane.getChildren().addAll(lblName, txtName);

        HBox surnamePane = new HBox(5);
        Label lblSurname = new Label("Surname:");
        TextField txtSurname = new TextField();
        surnamePane.getChildren().addAll(lblSurname, txtSurname);

        VBox weekdaysPane = new VBox(5);
        Label lblAppointment = new Label("Select Appointment Days:");
        CheckBox monday = new CheckBox("Monday");
        CheckBox tuesday = new CheckBox("Tesday");
        CheckBox wednesday = new CheckBox("Wednesday");
        CheckBox thursday = new CheckBox("Thursday");
        CheckBox friday = new CheckBox("Friday");
        weekdaysPane.getChildren().addAll(lblAppointment, monday, tuesday, wednesday, thursday, friday);

        VBox typePane = new VBox(5);
        Label lblType = new Label("Select Appointment Type:");
        ComboBox<String> cmbType = new ComboBox<>();
        cmbType.getItems().addAll("Counseling", "Medical", "Shelter");
        typePane.getChildren().addAll(lblType, cmbType);

        Label lblPregnant = new Label("Pregnant:");
        ToggleGroup group = new ToggleGroup();
        RadioButton yes = new RadioButton("Yes");
        RadioButton no = new RadioButton("No");
        yes.setToggleGroup(group);
        no.setToggleGroup(group);
        HBox radioPane = new HBox(10, lblPregnant, yes, no);

        Button registerButton = new Button("Register");
        Label lblWelcome = new Label("Please enter your credentials:");
        TableView<User> tableView = new TableView<>();
        ObservableList<User> userData = FXCollections.observableArrayList();

        TableColumn<User, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> colSurname = new TableColumn<>("Surname");
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<User, String> colPregnant = new TableColumn<>("Pregnant");
        colPregnant.setCellValueFactory(new PropertyValueFactory<>("pregnantStatus"));

        TableColumn<User, String> colDays = new TableColumn<>("Days");
        colDays.setCellValueFactory(new PropertyValueFactory<>("appointmentDays"));

        TableColumn<User, String> colType = new TableColumn<>("Type");
        colType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));

        tableView.getColumns().addAll(colName, colSurname, colPregnant, colDays, colType);
        tableView.setItems(userData);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lblWelcome, namePane, surnamePane, weekdaysPane, typePane, radioPane, registerButton, tableView);

        registerButton.setOnAction((ActionEvent event) -> {
            String name = txtName.getText();
            String surname = txtSurname.getText();
            String selectedType = cmbType.getValue();

            StringBuilder selectedDays = new StringBuilder();
            if (monday.isSelected()) selectedDays.append("Monday");
            if (tuesday.isSelected()) selectedDays.append("Tuesday");
            if (wednesday.isSelected()) selectedDays.append("Wednesday");
            if (thursday.isSelected()) selectedDays.append("Thursday");
            if (friday.isSelected()) selectedDays.append("Fridday");

            if (selectedDays.length() > 0) {
                selectedDays.setLength(selectedDays.length() - 2);
            }

            RadioButton selectedRadio = (RadioButton) group.getSelectedToggle();
            String pregnantStatus = (selectedRadio != null && selectedRadio.getText().equals("Yes")) ? "Pregnant" : "Non-pregnant";


            userData.add(new User(name, surname, pregnantStatus, selectedDays.toString(), (selectedType != null ? selectedType : "Not Selected")));
            Storage storage = new Storage();
            storage.save(name + " " + surname + " " + pregnantStatus + " " + selectedDays + " " + selectedType);
            txtName.clear();
            txtSurname.clear();
            cmbType.getSelectionModel().clearSelection();
            monday.setSelected(false);
            tuesday.setSelected(false);
            wednesday.setSelected(false);
            thursday.setSelected(false);
            friday.setSelected(false);
            group.selectToggle(null);
        });

        Scene scene = new Scene(layout, 500, 500);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }

    }



