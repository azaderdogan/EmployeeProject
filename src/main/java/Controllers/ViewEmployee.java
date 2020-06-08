package Controllers;

import DB_Source.DBInfo;
import Person.Employees;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewEmployee   implements Initializable {



    @FXML
    private TableView<Employees> table;

    @FXML
    private TableColumn<Employees, Integer> id;

    @FXML
    private TableColumn<Employees, String> fname;

    @FXML
    private TableColumn<Employees, String> lname;

    @FXML
    private TableColumn<Employees, Float> salary;

    @FXML
    private TableColumn<Employees, Integer> age;

    @FXML
    private TableColumn<Employees, String> department;

    @FXML
    private TableColumn<Employees, String> address;

    @FXML
    private TableColumn<Employees, String> dateOfBirth;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Employees,Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Employees,String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Employees,String>("lname"));
        salary.setCellValueFactory(new PropertyValueFactory<Employees,Float>("salary"));
        age.setCellValueFactory(new PropertyValueFactory<Employees,Integer>("age"));
        department.setCellValueFactory(new PropertyValueFactory<Employees,String>("department"));
        address.setCellValueFactory(new PropertyValueFactory<Employees,String>("address"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<Employees,String>("dateOfBirth"));

        Task<ObservableList<Employees>> listele=new listele();

        new Thread(listele).start();


        try {
            table.setItems(listele.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



    }
}
 class listele extends Task<ObservableList<Employees>> {
     public ObservableList<Employees> data= FXCollections.observableArrayList();
     @Override
     protected ObservableList<Employees> call() throws Exception {

         String sql="SELECT * from users where 1";
         try (

                 Connection connection= DBInfo.getConnection();
                 PreparedStatement pst=connection.prepareStatement(sql);
                 ResultSet rst=pst.executeQuery();
         ){

             System.err.println(Thread.currentThread().getName());
             while (rst.next()){
                 data.add(new Employees(
                         rst.getInt(1),
                         rst.getString(2),
                         rst.getString(3),
                         rst.getFloat(4),
                         rst.getInt(5),
                         rst.getString(6),
                         rst.getString(7),
                         rst.getString(8)

                 ));
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
         return data;
     }
 }