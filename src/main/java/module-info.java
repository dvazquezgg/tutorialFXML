module mx.edu.greengates.cs.tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens mx.edu.greengates.cs.tutorial to javafx.fxml;
    opens mx.edu.greengates.cs.tutorial.beto to javafx.fxml;
    opens mx.edu.greengates.cs.tutorial.val to javafx.fxml;
    opens mx.edu.greengates.cs.tutorial.pau to javafx.base;
    exports mx.edu.greengates.cs.tutorial;
    exports mx.edu.greengates.cs.tutorial.beto;
    exports mx.edu.greengates.cs.tutorial.val;
    exports mx.edu.greengates.cs.tutorial.pau;
}