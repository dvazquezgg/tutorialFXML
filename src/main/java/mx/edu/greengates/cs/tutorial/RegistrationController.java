package mx.edu.greengates.cs.tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private RadioButton rbPregnant;

    @FXML
    private RadioButton rbNotPregnant;

    @FXML
    private CheckBox chkMon;

    @FXML
    private CheckBox chkTue;

    @FXML
    private CheckBox chkWed;

    @FXML
    private CheckBox chkThu;

    @FXML
    private CheckBox chkFri;

    @FXML
    private ComboBox<String> cbAppointmentType;

    @FXML
    private void onButtonClicked() {


        String name = txtName.getText();
        String surname = txtSurname.getText();

        // Name validation
        if (name.isEmpty() || surname.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error");
            alert.setContentText("Please enter your name and surname");
            alert.show();
            return;
        }

        ToggleGroup pregnancy = rbPregnant.getToggleGroup();
        // Pregnancy validation
        RadioButton selectedPregnancy = (RadioButton) pregnancy.getSelectedToggle();
        if (selectedPregnancy == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error");
            alert.setContentText("Please select if you are pregnant or not");
            alert.show();
            return;
        }

        // Days validation
        boolean daysSelected = false;
        CheckBox[] chkDays = {chkMon, chkTue, chkWed, chkThu, chkFri};

        for (CheckBox chkDay : chkDays) {
            if (chkDay.isSelected()) {
                daysSelected = true;
                break;
            }
        }

        if (!daysSelected) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error");
            alert.setContentText("Please select at least one day");
            alert.show();
            return;
        }

        // Appointment type validation
        if (cbAppointmentType.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error");
            alert.setContentText("Please select an appointment type");
            alert.show();
            return;
        }

        String appointmentType = cbAppointmentType.getValue();
        if (appointmentType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error");
            alert.setContentText("Please select an appointment type");
            alert.show();
            return;
        }

        // Show the confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Registration successful");
        StringBuilder message = new StringBuilder();
        message.append("Name: ").append(name).append("\n");
        message.append("Surname: ").append(surname).append("\n");
        message.append("Pregnant: ").append(selectedPregnancy.getText()).append("\n");
        message.append("Days: ").append(getSelectedDays(chkDays)).append("\n");
        message.append("Appointment type: ").append(appointmentType);
        alert.setContentText(message.toString());
        alert.show();

        // Create a new user object that holds the data
        User user = new User(name, surname, selectedPregnancy.getText().equals("Yes"), appointmentType);
        for (int i = 0; i < chkDays.length; i++) {
            if (chkDays[i].isSelected()) {
                user.addDay(i);
            }
        }

        // Clear the text fields
        txtName.clear();
        txtSurname.clear();

        // Clear the radio buttons
        pregnancy.selectToggle(null);

        // Clear the check boxes
        for (CheckBox chkDay : chkDays) {
            chkDay.setSelected(false);
        }

        // Clear the combo box
        cbAppointmentType.getSelectionModel().clearSelection();

        // Save the data to the output text file
        Storage storage = new Storage();
        storage.save(message.toString());

        // Save the data to the database
        StorageDB storageDB = new StorageDB();
        storageDB.save(user);
    }

    /**
     * Get the selected days
     * @param chkDays
     * @return selectedDays
     *
     * This method takes an array of CheckBoxes and returns a string with the selected days.
     */
    private String getSelectedDays(CheckBox[] chkDays) {
        StringBuilder selectedDays = new StringBuilder();
        for (CheckBox chkDay : chkDays) {
            if (chkDay.isSelected()) {
                selectedDays.append(chkDay.getText()).append(", ");
            }
        }
        return selectedDays.toString();
    }
}
