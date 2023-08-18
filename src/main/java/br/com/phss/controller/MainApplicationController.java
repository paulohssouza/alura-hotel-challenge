package br.com.phss.controller;

import br.com.phss.factory.ViewsFactory;
import br.com.phss.utils.DialogBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainApplicationController implements Initializable {

    @FXML
    public Button loginViewButton;
    @FXML
    public Button closeButton;
    private ViewsFactory viewsFactory = new ViewsFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginViewButtonAction(MouseEvent mouseEvent) throws IOException {
        viewsFactory.loginViewCreate();
    }

    public void closeAction(MouseEvent mouseEvent) {
        DialogBox.confirmationBox();
    }
}
