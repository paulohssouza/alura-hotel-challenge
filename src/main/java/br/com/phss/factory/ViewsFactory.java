package br.com.phss.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ViewsFactory {

    private Stage stage = new Stage();

    public Stage mainApplicationViewCreate() {
        Parent root = createRoot("/views/main-application-view.fxml");
        return getStage(root);
    }
    public Stage loginViewCreate() {
        Parent root = createRoot("/views/login-view.fxml");
        return getStage(root);
    }

    public Stage userMenuView() {
        Parent root = createRoot("/views/user-menu-view.fxml");
        return getStage(root);
    }

    public Stage bookRecordView() {
        Parent root = createRoot("/views/book-record-view.fxml");
        return getStage(root);
    }

    public Stage searchSystemView() {
        Parent root = createRoot("/views/search-system-view.fxml");
        return getStage(root);
    }

    private Stage getStage(Parent root) {
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(scene);
        return stage;
    }

    private Parent createRoot(String viewPath) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(viewPath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return root;
    }
}
