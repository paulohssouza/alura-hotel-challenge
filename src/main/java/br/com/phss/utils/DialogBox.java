package br.com.phss.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogBox {
    public static void confirmationBox(Stage stage) {
        Alert confirmaationBox = new Alert(Alert.AlertType.CONFIRMATION);
        confirmaationBox.setHeaderText("Confirmação de saída!!");
        confirmaationBox.setContentText("Deseja mesmo sair?");
        Optional<ButtonType> result = confirmaationBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            stage.close();
            confirmaationBox.close();
        }
    }

    public static void loginSuccessfully(String login) {
        Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
        loginSuccess.setHeaderText("Login com sucesso.");
        loginSuccess.setContentText("usuário " + login + " autenticado com sucesso.");
        loginSuccess.showAndWait();
    }

    public static void loginFailure() {
        Alert loginFail = new Alert(Alert.AlertType.INFORMATION);
        loginFail.setHeaderText("Falha de login.");
        loginFail.setContentText("usuário ou senha inválidos.");
        loginFail.showAndWait();
    }
}
