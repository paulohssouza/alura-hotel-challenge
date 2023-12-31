package br.com.phss.controller;

import br.com.phss.factory.ChangeScene;
import br.com.phss.factory.ViewsList;
import br.com.phss.utils.DialogBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainApplicationController implements Initializable {

    @FXML
    public Button loginViewButton;
    @FXML
    public Button closeButton;
    @FXML
    public AnchorPane mainApplicationView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loginViewButtonAction() {
        ChangeScene.changeScene(ViewsList.LOGIN).show();
    }

    public void closeAction() {
        DialogBox.confirmationBox(ViewsList.MAIN);
        System.exit(0);
    }
}
