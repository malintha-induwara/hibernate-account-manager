package lk.ijse.accountManager.controller;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.accountManager.entity.Student;
import lk.ijse.accountManager.model.StudentModel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ManageAccountFormController {

    private final StudentModel studentModel = new StudentModel();
    @FXML
    private AnchorPane paneCreateAccount;
    @FXML
    private MFXDatePicker dpBirthdate;
    @FXML
    private MFXTextField txtFirstName;
    @FXML
    private MFXTextField txtHomeNumber;
    @FXML
    private MFXTextField txtUsername;
    @FXML
    private MFXTextField txtLastName;
    @FXML
    private MFXTextField txtMobileNumber;
    @FXML
    private MFXPasswordField txtPassword;
    @FXML
    private MFXPasswordField txtReEnterPassword;
    @FXML
    private Text lblErrorMsg;
    @FXML
    private MFXTextField txtId;

    @FXML
    void btnCancelOnAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    void btnCreateAccountOnAction(ActionEvent event) {

        boolean isValidate = validateFields();
        if (!isValidate) {
            return;
        }

        String userName = txtUsername.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String homeNumber = txtHomeNumber.getText();
        String password = txtPassword.getText();
        LocalDate birthdate = dpBirthdate.getValue();

        Student student = new Student(userName, firstName, lastName, mobileNumber, homeNumber, password, birthdate);
        boolean isSaved = studentModel.saveStudent(student);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Student Saved Successfully").show();
            clearFields();
        }
    }


    @FXML
    void btnSearchAccountOnAction(ActionEvent event) {

        boolean isTxtIdExist = !txtId.getText().isEmpty();

        if (!isTxtIdExist) {
            new Alert(Alert.AlertType.ERROR, "Enter a  Id").show();
            return;
        }


        int studentId = Integer.parseInt(txtId.getText());
        Student student = studentModel.searchStudent(studentId);
        if (student == null) {
            new Alert(Alert.AlertType.ERROR, "Student Not Found").show();
            clearFields();
            return;
        }

        txtUsername.setText(student.getUserName());
        txtFirstName.setText(student.getName().getFistName());
        txtLastName.setText(student.getName().getLastName());
        txtMobileNumber.setText(student.getNumbers().get(0).getNumber());
        txtHomeNumber.setText(student.getNumbers().get(1).getNumber());
        txtPassword.setText(student.getPassword());
        txtReEnterPassword.setText(student.getPassword());
        dpBirthdate.setValue(student.getBirthdate());

    }

    @FXML
    void btnUpdateAccountOnAction(ActionEvent event) {

        boolean isValidate = validateFields();

        String studentId = txtId.getText();

        boolean isTxtIdExist = !studentId.isEmpty();

        if (!isValidate || !isTxtIdExist) {
            return;
        }

        boolean isUserExist = studentModel.searchStudent(Integer.parseInt(studentId)) != null;
        if (!isUserExist) {
            new Alert(Alert.AlertType.ERROR, "Invalid Id").show();
            return;
        }

        String userName = txtUsername.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String homeNumber = txtHomeNumber.getText();
        String password = txtPassword.getText();
        LocalDate birthdate = dpBirthdate.getValue();

        Student student = new Student(userName, firstName, lastName, mobileNumber, homeNumber, password, birthdate);

        boolean isUpdated = studentModel.updateStudent(Integer.parseInt(studentId), student);

        if (!isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Student Didn't Update").show();
        }

        new Alert(Alert.AlertType.INFORMATION, "Student Updated Successfully").show();
    }


    @FXML
    void btnDeleteAccountOnAction(ActionEvent event) {

        String studentId = txtId.getText();

        boolean isTxtIdExist = !studentId.isEmpty();

        if (!isTxtIdExist) {
            new Alert(Alert.AlertType.ERROR, "Enter a  Id").show();
            return;
        }


        Student student = studentModel.searchStudent(Integer.parseInt(studentId));
        if (student == null) {
            new Alert(Alert.AlertType.ERROR, "Student Not Found").show();
            return;
        }

        boolean isDeleted = studentModel.deleteStudent(Integer.parseInt(studentId));
        if (!isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "Student Didn't Delete").show();
        }

        new Alert(Alert.AlertType.INFORMATION, "Student Deleted Successfully").show();
        clearFields();
    }


    private void clearFields() {
        txtUsername.clear();
        txtFirstName.clear();
        txtLastName.clear();
        txtMobileNumber.clear();
        txtHomeNumber.clear();
        txtPassword.clear();
        txtReEnterPassword.clear();
        dpBirthdate.setValue(null);
    }

    private boolean validateFields() {

        String userName = txtUsername.getText();

        boolean isUserNameValid = Pattern.matches("^[a-zA-Z0-9]{3,}$", userName);
        if (!isUserNameValid) {
            txtUsername.requestFocus();
            txtUsername.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtUsername.getStyleClass().removeAll("mfx-text-field-error");


        String firstName = txtFirstName.getText();

        boolean isFirstNameValid = Pattern.matches("^[a-zA-Z]{3,}$", firstName);

        if (!isFirstNameValid) {
            txtFirstName.requestFocus();
            txtFirstName.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtFirstName.getStyleClass().removeAll("mfx-text-field-error");

        String lastName = txtLastName.getText();

        boolean isLastNameValid = Pattern.matches("^[a-zA-Z]{3,}$", lastName);

        if (!isLastNameValid) {
            txtLastName.requestFocus();
            txtLastName.getStyleClass().add("mfx-text-field-error");
            return false;
        }


        txtLastName.getStyleClass().removeAll("mfx-text-field-error");


        boolean isBirthdateValid = dpBirthdate.getValue() != null;

        if (!isBirthdateValid) {
            dpBirthdate.requestFocus();
            dpBirthdate.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        dpBirthdate.getStyleClass().removeAll("mfx-text-field-error");

        String mobileNumber = txtMobileNumber.getText();

        boolean isMobileNumberValid = Pattern.matches("^[0-9]{10}$", mobileNumber);

        if (!isMobileNumberValid) {
            txtMobileNumber.requestFocus();
            txtMobileNumber.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtMobileNumber.getStyleClass().removeAll("mfx-text-field-error");

        String homeNumber = txtHomeNumber.getText();

        boolean isHomeNumberValid = Pattern.matches("^[0-9]{10}$", homeNumber);

        if (!isHomeNumberValid) {
            txtHomeNumber.requestFocus();
            txtHomeNumber.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtHomeNumber.getStyleClass().removeAll("mfx-text-field-error");


        String password = txtPassword.getText();

        boolean isPasswordValid = Pattern.matches("^[a-zA-Z]{3,}$", password);

        if (!isPasswordValid) {
            txtPassword.requestFocus();
            txtPassword.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtPassword.getStyleClass().removeAll("mfx-text-field-error");

        String passwordReEnter = txtReEnterPassword.getText();

        boolean isReEnterPasswordValid = Pattern.matches("^[a-zA-Z]{3,}$", passwordReEnter);

        if (!isReEnterPasswordValid) {
            txtReEnterPassword.requestFocus();
            txtReEnterPassword.getStyleClass().add("mfx-text-field-error");
            return false;
        }

        txtReEnterPassword.getStyleClass().removeAll("mfx-text-field-error");

        boolean isPasswordMatch = password.equals(passwordReEnter);

        if (!isPasswordMatch) {
            lblErrorMsg.setVisible(true);
            return false;
        }

        lblErrorMsg.setVisible(false);
        return true;
    }


}

