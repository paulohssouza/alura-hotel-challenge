package br.com.phss.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ViewsFactory {

    Stage stage = new Stage();

    public Stage mainApplicationViewCreate() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/main-application-view.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(scene);
        return stage;
    }
    public Stage loginViewCreate() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/login-view.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(scene);
        return stage;
    }
}
