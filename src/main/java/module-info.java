module EmployeeProject {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires java.sql;
    opens Person to javafx.base;
    opens Controllers to javafx.fxml;
    opens DB_Source to java.sql;
    requires mysql.connector.java;
    opens com.azaderdogan to javafx.graphics;
}