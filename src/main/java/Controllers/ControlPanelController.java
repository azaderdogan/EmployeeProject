package Controllers;


import Person.Employees;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlPanelController{

    @FXML
    private Label label;
    @FXML
    void insertEmployee(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(getClass().getResource("/FXML_Files/Insert.fxml"));
        Stage stage =new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void updateDelete(ActionEvent event) throws IOException {


        Stage stage=new Stage();
        Parent root =FXMLLoader.load(getClass().getResource("/FXML_Files/UpdateDelete.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void viewEmployee(ActionEvent event) throws IOException {

        Stage stage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("/FXML_Files/ViewEmployee.fxml"));
        Scene scene=new Scene(root,982,593);
        stage.setScene(scene);
        stage.show();

    }

}
