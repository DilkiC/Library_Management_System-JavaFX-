package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LDashBoardFormController  {
    public AnchorPane rootDash;
    public AnchorPane root2;

    public  void initialize() throws IOException {
        loadHome();
    }

    private void loadHome() throws IOException {
        setUi("LHomeForm");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LMemberRegistrationForm");
    }

    public void issueOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LIssueForm");
    }

    public void returnOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LReturnForm");
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LHomeForm");
    }

    public void bookOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LBookForm");
    }

    public void manageOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LMemberManageForm");
    }

    private void setUi(String LHomeForm) throws IOException {
        rootDash.getChildren().clear();
        rootDash.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+LHomeForm+".fxml")));
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) this.root2.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }

    public void AddBooksOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddBooks");
    }


}
