package br.com.phss.controller;

import br.com.phss.factory.ViewsFactory;
import br.com.phss.utils.DialogBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainApplicationController implements Initializable {

    @FXML
    public Button loginViewButton;
    @FXML
    public Button closeButton;
    private final ViewsFactory viewsFactory = new ViewsFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loginViewButtonAction(MouseEvent mouseEvent) throws IOException {
        viewsFactory.loginViewCreate().show();
    }

    public void closeAction(MouseEvent mouseEvent) throws IOException {
        DialogBox.confirmationBox((Stage) closeButton.getScene().getWindow());
    }
}
