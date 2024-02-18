package lk.ijse.accountManager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.accountManager.entity.Student;
import lk.ijse.accountManager.model.StudentModel;
import lk.ijse.accountManager.tm.StudentTm;
import org.hibernate.Hibernate;

import java.io.IOException;
import java.util.List;

public class ViewAccountFormController {

    @FXML
    private TableColumn<?, ?> colBirthdate;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colMobileNum;

    @FXML
    private TableView<StudentTm> tblAccounts;

    @FXML
    private AnchorPane viewPane;


    StudentModel studentModel = new StudentModel();

    public void initialize(){
        setCellValueFactories();
        loadStudentDetails();
    }

    private void setCellValueFactories() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colBirthdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colMobileNum.setCellValueFactory(new PropertyValueFactory<>("mobileNum"));
    }

    private void loadStudentDetails() {
        ObservableList<StudentTm> obList = FXCollections.observableArrayList();

        List<Student> studentList =studentModel.getAllStudents();

        for (Student student : studentList) {

            obList.add(new StudentTm(student.getName().getFistName(), student.getName().getLastName(), student.getBirthdate(), student.getNumbers().get(0).getNumber()));
        }
        tblAccounts.setItems(obList);
    }

    @FXML
    void btnAccountOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/manageAccountForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) this.viewPane.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Account");
    }



}

