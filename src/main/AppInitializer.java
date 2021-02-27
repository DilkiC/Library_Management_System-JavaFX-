package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/WelcomeForm.fxml"))));
        primaryStage.show();
    }
}
