package br.com.phss;

import br.com.phss.factory.ViewsFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    private final ViewsFactory viewsFactory = new ViewsFactory();
    private final Stage stageMain = viewsFactory.mainApplicationViewCreate();

    public MainApplication() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stageMain.show();
    }
}
