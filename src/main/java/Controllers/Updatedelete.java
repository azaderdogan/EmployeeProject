package Controllers;

import DB_Source.DBInfo;
import Person.Employees;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

import static javafx.scene.control.ButtonType.*;

public class Updatedelete {
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
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField gender;

    @FXML
    private JFXButton btnDelete;


    @FXML
    private JFXTextField dateOfBirth;

    @FXML
    private JFXButton btnCancel;


    @FXML
    private JFXTextField idField;

    @FXML
    private JFXButton btnFind;
    @FXML
    private JFXTextField contractStart;

    @FXML
    private JFXTextField contractEnd;


    @FXML
    void find(ActionEvent event) {

        String sİd = idField.getText();
        int id = Integer.parseInt(sİd);
        Employees employee = DBInfo.getEmployee(id);

        fname.setText(employee.getFname());
        lname.setText(employee.getLname());
        salary.setText(String.valueOf(employee.getSalary()));
        age.setText(String.valueOf(employee.getAge()));
        department.setText(employee.getDepartment());
        address.setText(employee.getAddress());
        nationaly.setText(employee.getNationaly());
        education.setText(employee.getEducation());
        experience.setText(employee.getExperience());
        motherLanguage.setText(employee.getMotherLanguage());
        otherLanguage.setText(employee.getOtherLanguage());
        dateOfBirth.setText(employee.getDateOfBirth());
        contractStart.setText(employee.getContractStart());
        contractEnd.setText(employee.getContractEnd());
        gender.setText(employee.getGender());

    }

    @FXML
    void cancel(ActionEvent event) {
        gender.getScene().getWindow().hide();
    }

    @FXML
    void delete(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete");
        alert.setHeaderText("Warning!");
        alert.setContentText("Delete?");
        alert.getButtonTypes().add(CANCEL);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();
        if (optionalButtonType.get().getText().equals("OK")) {
            int status = DBInfo.delete(Integer.parseInt(idField.getText()));
            if (status > 0) {
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Delete");
                alert1.setHeaderText("Confirmation!");
                alert1.setContentText("Deleted!");
                alert1.showAndWait();
            }
        } else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Delete");
            alert1.setHeaderText("Confirmation!");
            alert1.setContentText("Not deleted!");
            alert1.showAndWait();
        }

    }

    @FXML
    void update(ActionEvent event) {


        String firstName = fname.getText();
        String lastName = lname.getText();
        String textSalary = salary.getText();
        String textAge = age.getText();
        String textDepartment = department.getText();
        String textAddress = address.getText();
        String textGender = gender.getText();
        String textEducation = education.getText();
        String textExperience = experience.getText();
        String textNationaly = nationaly.getText();
        String motherlanguage = motherLanguage.getText();
        String otherlanguage = otherLanguage.getText();


        float fSalary = Float.parseFloat(textSalary);
        int iAge = Integer.parseInt(textAge);


        Employees employees = new Employees();
        employees.setId(Integer.parseInt(idField.getText()));
        employees.setFname(firstName);
        employees.setLname(lastName);
        employees.setSalary(fSalary);
        employees.setAge(iAge);
        employees.setGender(textGender);
        employees.setDepartment(textDepartment);
        employees.setAddress(textAddress);
        employees.setDateOfBirth(dateOfBirth.getText());
        employees.setGender(textGender);
        employees.setEducation(textEducation);
        employees.setExperience(textExperience);
        employees.setNationaly(textNationaly);
        employees.setContractEnd(contractEnd.getText());
        employees.setContractStart(contractStart.getText());
        employees.setMotherLanguage(motherlanguage);
        employees.setOtherLanguage(otherlanguage);


        int status = DBInfo.update(employees);
        if (status > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Data Update");
            alert.setHeaderText("Information Dialog");
            alert.setContentText(" Update succesfully!");
            alert.showAndWait();
            System.out.println(" update succesfully!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Insert");
            alert.setHeaderText("Error Dialog");
            alert.setContentText("Sorry ! unable to update !");
            alert.showAndWait();
            System.out.println("Sorry ! unable to update !");
        }
    }
}
