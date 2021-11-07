package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Student;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    List<Student> Students = new ArrayList<Student>();
    int lastID = -1;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtPhone;

    @FXML
    private Label lblHeading;

    @FXML
    private ComboBox<String> cbMajor;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtState;

    @FXML
    private DatePicker dateDate;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private Button btnSubmit;

    @FXML
    void onSubmitButtonClick() {

        ObservableList<String> Errors = FXCollections.observableArrayList();
        boolean validationCheck = true;
        int id = ++lastID;

        //First Name validation
        String firstName = txtFirstName.getText();
        if(firstName.isEmpty()){
            validationCheck = false;
            System.out.println("First Name empty");
            Errors.add("First Name must be filled");
        } else{
            System.out.println("First Name not empty");
        }


        //Last Name validation
        String lastName = txtLastName.getText();
        if(lastName.isEmpty()){
            validationCheck = false;
            System.out.println("Last Name empty");
            Errors.add("Last Name must be filled");
        } else {
            System.out.println("Last Name not empty");
        }

        //DoB validation
        LocalDate birthDate = dateDOB.getValue();
        if(dateDOB.getValue() == null) {
            validationCheck = false;
            System.out.println("DoB is empty");
            Errors.add("DoB must be properly selected");
        } else {
            System.out.println("DoB properly selected");
        }


        //Address validation
        String address = txtAddress.getText();
        if(address.isEmpty()){
            validationCheck = false;
            System.out.println("Address empty");
            Errors.add("Address must be filled");
        } else {
            System.out.println("Address not empty");
        }

        //City validation
        String city = txtCity.getText();
        if(city.isEmpty()){
            validationCheck = false;
            System.out.println("City empty");
            Errors.add("City must be filled");
        } else {
            System.out.println("City not empty");
        }

        //State validation
        String state = txtState.getText();
        if(state.isEmpty()){
            validationCheck = false;
            System.out.println("State empty");
            Errors.add("State must be filled");
        } else {
            System.out.println("State not empty");
        }

        //Phone validation
        int phone = 0;
        try {
            phone = Integer.parseInt(txtPhone.getText());
        } catch (NumberFormatException e) {
            validationCheck = false;
            if(txtPhone.getText().isEmpty()){
                System.out.println("Phone empty");
                Errors.add("Phone must be filled");
            } else {
                System.out.println("Phone not integer");
                Errors.add("Phone may only be numbers");
            }
        }

        //Email validation
        String email = txtEmail.getText();
        if(email.isEmpty()){
            validationCheck = false;
            System.out.println("Email empty");
            Errors.add("Email must be filled");
        } else {
            if(!email.contains("@") && !email.contains(".")){
                validationCheck = false;
                System.out.println("Email improperly formatted");
                Errors.add("Email must be properly formatted");
            }
            System.out.println("Email not empty");
        }

        //Major validation
        String major = cbMajor.getValue();
        if(major == null) {
            System.out.println("Major empty");
            Errors.add("A major must be selected");
        } else {
            System.out.println("Major not empty");
        }

        //Date validation
        LocalDate date = dateDate.getValue();
        if(dateDate.getValue() == null) {
            validationCheck = false;
            System.out.println("Date is empty");
            Errors.add("Date must be properly selected");
        } else {
            System.out.println("Date properly selected");
        }

        //Student Object Creation
        if(validationCheck == true) {
            Student student = new Student(id, firstName, lastName, birthDate, address, city, state, phone, email, major, date);
            Students.add(student);
            System.out.println(Students.toString());
            System.out.println(phone);
            lblHeading.setText(student.toString() + " has been successfully added!");
        } else {
            lblHeading.setText(String.valueOf(Errors));

        }





    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> Majors = FXCollections.observableArrayList("Computer Science", "English", "General", "Information Technology", "Undeclared");
        cbMajor.setItems(Majors);




    }
}