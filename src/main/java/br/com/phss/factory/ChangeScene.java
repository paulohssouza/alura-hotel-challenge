package br.com.phss.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ChangeScene {

    private static Stage stage = new Stage();

    public static Stage changeScene(ViewsList viewsList) {
        switch (viewsList) {
            case MAIN:
                stage = setStage("/views/main-application-view.fxml");
                break;
            case LOGIN:
                stage = setStage("/views/login-view.fxml");
                break;
            case USERMENU:
                stage = setStage("/views/user-menu-view.fxml");
                break;
            case BOOKRECORD:
                stage = setStage("/views/book-record-view.fxml");
                break;
            case SEARCHSYSTEM:
                setStage("/views/search-system-view.fxml");
                break;
            case GUESTRECORD:
                setStage("/views/guest-record-view.fxml");
                break;
        }
        return stage;
    }

    private static Stage setStage(String pathView) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(ChangeScene.class.getResource(pathView)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }
}
