package br.com.phss;

import br.com.phss.factory.ChangeScene;
import br.com.phss.factory.ViewsList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApplication extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ChangeScene.changeScene(ViewsList.MAIN).initStyle(StageStyle.UNDECORATED);
        ChangeScene.changeScene(ViewsList.MAIN).centerOnScreen();
        ChangeScene.changeScene(ViewsList.MAIN).setResizable(false);
        ChangeScene.changeScene(ViewsList.MAIN).show();
    }
}
