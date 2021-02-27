package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.regex.Pattern;

public class LoginFormController {

    public AnchorPane rootLogin;
    public JFXPasswordField pwd;
    public JFXTextField txtUser;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) this.rootLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/WelcomeForm.fxml"))));
        stage.centerOnScreen();
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {

        if(Pattern.compile("^[A-z]{3,}$").matcher(txtUser.getText()).matches()){
            pwd.requestFocus();
        }else{
            txtUser.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void pwdLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUser.getText().trim().equalsIgnoreCase("Lib") && pwd.getText().trim().equalsIgnoreCase("1234")){
            Stage window = (Stage) this.rootLogin.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(this.getClass()
                    .getResource("/view/LDashBoardForm.fxml"))));
            window.centerOnScreen();

        }else {
            new Alert(Alert.AlertType.WARNING,"Wrong User Name or Password", ButtonType.CLOSE,ButtonType.OK).show();
        }
    }
}
