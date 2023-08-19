package br.com.phss.controller;

import br.com.phss.factory.ViewsFactory;
import br.com.phss.utils.DialogBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Button closeButtonLogin;
    @FXML
    public Button enterButtonLogin;
    @FXML
    public TextField passwordTextFiledLogin;
    @FXML
    public TextField userTextFieldLogin;
    private ViewsFactory viewsFactory = new ViewsFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginAction(MouseEvent mouseEvent) {
    }

    public void closeAction(MouseEvent mouseEvent) throws IOException {
        DialogBox.confirmationBox((Stage) closeButtonLogin.getScene().getWindow());
    }
}
