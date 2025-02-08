package mx.edu.greengates.cs.tutorial.val;

public class User {
    private final String name;
    private final String surname;
    private final String pregnantStatus;
    private final String appointmentDays;
    private final String appointmentType;

    public User(String name, String surname, String pregnantStatus, String appointmentDays, String appointmentType) {
        this.name = name;
        this.surname = surname;
        this.pregnantStatus = pregnantStatus;
        this.appointmentDays = appointmentDays;
        this.appointmentType = appointmentType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPregnantStatus() {
        return pregnantStatus;
    }

    public String getAppointmentDays() {
        return appointmentDays;
    }

    public String getAppointmentType() {
        return appointmentType;
    }
}
