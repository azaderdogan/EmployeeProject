package Controllers;

import DB_Source.DBInfo;
import Person.Employees;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class InsertController {

    @FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField lname;

    @FXML
    private JFXTextField salary;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField education;

    @FXML
    private JFXTextField experience;

    @FXML
    private JFXTextField nationaly;

    @FXML
    private JFXTextField motherLanguage;

    @FXML
    private JFXTextField otherLanguage;

    @FXML
    private JFXDatePicker dateOfBirth;

    @FXML
    private JFXDatePicker contractStart;

    @FXML
    private JFXButton btnInsert;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXDatePicker contractEnd;
    @FXML
    void cancel(ActionEvent event) {

        gender.getScene().getWindow().hide();
    }
    @FXML
    void insert(ActionEvent event) {
        LocalDate dateBirth=dateOfBirth.getValue();
        LocalDate dateStart=contractStart.getValue();
        LocalDate dateEnd=contractEnd.getValue();

        String firstName=fname.getText();
        String lastName=lname.getText();
        String textSalary=salary.getText();
        String textAge=age.getText();
        String textDepartment=department.getText();
        String textAddress=address.getText();
        String textGender=gender.getText();
        String textEducation=education.getText();
        String textExperience=experience.getText();
        String textNationaly=nationaly.getText();
        String motherlanguage=motherLanguage.getText();
        String otherlanguage=otherLanguage.getText();

        String dateOfBirth=dateBirth.toString();
        String contractStart=dateStart.toString();
        String contractEnd=dateEnd.toString();

        float fSalary=Float.parseFloat(textSalary);
        int iAge=Integer.parseInt(textAge);

        Employees employees=new Employees();
        employees.setFname(firstName);
        employees.setLname(lastName);
        employees.setSalary(fSalary);
        employees.setAge(iAge);
        employees.setGender(textGender);
        employees.setDepartment(textDepartment);
        employees.setAddress(textAddress);
        employees.setDateOfBirth(dateOfBirth);
        employees.setGender(textGender);
        employees.setEducation(textEducation);
        employees.setExperience(textExperience);
        employees.setNationaly(textNationaly);
        employees.setContractEnd(contractEnd);
        employees.setContractStart(contractStart);
        employees.setMotherLanguage(motherlanguage);
        employees.setOtherLanguage(otherlanguage);


        int status= DBInfo.save(employees);
        if (status>0){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Data Insert");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record saved succesfully!");
            alert.showAndWait();
            System.out.println("Record saved succesfully!");
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Insert");
            alert.setHeaderText("Error Dialog");
            alert.setContentText("Sorry ! unable to save Record!");
            alert.showAndWait();
            System.out.println("Sorry ! unable to save Record!");
        }
    }
}
