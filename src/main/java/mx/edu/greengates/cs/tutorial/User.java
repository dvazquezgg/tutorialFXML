package mx.edu.greengates.cs.tutorial;

public class User {
    private String name;
    private String surname;
    private boolean pregnant;
    private boolean[] days;
    private String appointmentType;

    public User(String name, String surname, boolean pregnant, String appointmentType) {
        this.name = name;
        this.surname = surname;
        this.pregnant = pregnant;
        boolean[] allDays = new boolean[7];
        for (int i = 0; i < 7; i++) {
            allDays[0] = false;
        }
        this.days = allDays;
        this.appointmentType = appointmentType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public boolean[] getDays() {
        return days;
    }

    public void addDay(int day) {
        days[day] = true;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

}
