module mx.edu.greengates.cs.tutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.edu.greengates.cs.tutorial to javafx.fxml;
    exports mx.edu.greengates.cs.tutorial;
}