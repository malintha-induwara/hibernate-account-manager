package lk.ijse.accountManager.controller;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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

}

