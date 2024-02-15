package lk.ijse.accountManager.controller;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.regex.Pattern;

public class ManageAccountFormController {

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

