package br.com.phss.controller;

import br.com.phss.dao.UserDAO;
import br.com.phss.factory.ViewsList;
import br.com.phss.model.User;
import br.com.phss.model.service.Authentication;
import br.com.phss.utils.DialogBox;
import br.com.phss.utils.JPAUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginAction() {
        UserDAO userDAO = new UserDAO(JPAUtil.getEntityManager());
        User user = userDAO.findByLogin(userTextFieldLogin.getText());
        if(Authentication.authetication(user, passwordTextFiledLogin.getText())) {
            DialogBox.loginSuccessfully(user.getLogin(), ViewsList.USERMENU);
        } else {
            DialogBox.loginFailure();
        }
    }

    public void closeAction() {
        DialogBox.confirmationBox(ViewsList.MAIN);
    }
}
