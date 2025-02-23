package mx.edu.greengates.cs.tutorial;

/**
 * This class is responsible for storing the data in the database
 * It uses the Database class to connect to the database and execute the SQL queries
 * It uses the User class to get the data to be stored
 * It uses the CREATE_TABLE string to create the table in the database
 * It uses the url to connect to the database
 */
public class StorageDB {

    // JDBC URL for the SQLite database
    final String url= "jdbc:sqlite:TeenPregnant.sqlite";

    // Database name
    final String DATABASE = "TeenPregnant";

    // SQL query to create the table
    final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ConsultancyRecords (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    Name TEXT NOT NULL,\n" +
            "    Surname TEXT NOT NULL,\n" +
            "    Pregnant BOOLEAN NOT NULL CHECK (Pregnant IN (0, 1)), \n" +
            "    Days TEXT NOT NULL,\n" +
            "    ConsultancyType TEXT NOT NULL\n" +
            ");";

    final String dbScript = "TeenPregnant.sql"; // Database script

    // Database object
    private Database db;

    /**
     * Constructor
     *
     * It connects to the database and creates the table
     * It uses the CREATE_TABLE string to create the table
     * It uses the url to connect to the database
     */
    public StorageDB() {
        System.out.println("Connecting to " + url);
        this.db = new Database(url);
        db.createTables(CREATE_TABLE);
    }

    public StorageDB(String filename) {
        System.out.println("Connecting to " + filename);
        this.db = new Database(url);
        // Getting the database script from the file
        String script = db.readScript(filename);
        db.createTables(script);
    }

    /**
     * Save the user data to the database
     *
     * It uses the User class to get the data to be stored
     * It uses the url to connect to the database
     * It uses the INSERT string to insert the data into the database
     *
     * @param user
     */
    public void save(User user) {
        System.out.println("Saving to " + url);
        try {
            boolean[] days = user.getDays(); // Get the days the user selected
            StringBuilder daysString = new StringBuilder(); // Create a string to store the selected days
            String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; // Days of the week
            for (int i = 0; i < days.length; i++) { // Loop through the days
                if (days[i]) { // If the day is selected
                    daysString.append(daysOfWeek[i]).append(",");   // Add the day to the string
                }
            }
            // SQL query to insert the data into the database
            // In an INSERT statement, each value must be enclosed in single quotes
            // You get the table name and the column names from the CREATE_TABLE string
            // Then you provide the values to be inserted in the VALUES clause in the same order as the columns
            String sql = "INSERT INTO ConsultancyRecords (Name, Surname, Pregnant, Days, ConsultancyType) " +
                    "VALUES ('" + user.getName() + "', '"
                    + user.getSurname() + "', "
                    + user.isPregnant() + ", '"
                    + daysString.toString() + "', '"
                    + user.getAppointmentType() + "');";
            // Insert the data into the database passing the SQL query
            db.insert(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
