package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeFormController {

    public AnchorPane rootWelcome;

    public void adminLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) this.rootWelcome.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"))) );
        stage.centerOnScreen();
    }

    public void librarianLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) this.rootWelcome.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"))) );
        stage.centerOnScreen();
    }
}
