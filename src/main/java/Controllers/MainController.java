package Controllers;

import DB_Source.AdminsDB;
import Person.Admins;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    @FXML
    private Label dbConLb;
    @FXML
    private JFXTextField userField;

    @FXML
    private JFXPasswordField passField;


    @FXML
    private Label check;


    @FXML
    void enterclick(ActionEvent event) throws IOException {

        List<Admins> list= AdminsDB.getAdmins();
        Map<String,String> map=new HashMap<>();
        for (Admins a:list){
            map.put(a.getUsername(),a.getPassword());
        }

        if (map.containsKey(userField.getText())){
            String val2=map.get(userField.getText());
            if (val2.equals(passField.getText())){
                check.setText("Başarılı");
                AdminsDB.getCon();
                Stage primaryStage=new Stage();
                Parent root= FXMLLoader.load(getClass().getResource("/FXML_Files/ControlPanel.fxml"));
                Scene scene=new Scene(root,600,400);
                primaryStage.setScene(scene);
                check.getScene().getWindow();
                check.getScene().getWindow().hide();
                primaryStage.show();
            }
        }else
        {
            check.setText("Tekrar Deneyin");
        }

    }

    @FXML
    void statusDB(ActionEvent event) throws SQLException {

        if (!AdminsDB.getCon().isClosed()){
            check.setText("Bağlı");
        }else
        {
            check.setText("Bir sorun mu var?");
        }
    }


}
