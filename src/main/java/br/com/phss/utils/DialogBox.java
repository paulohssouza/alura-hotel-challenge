package br.com.phss.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogBox {
    private static Alert alertBox;
    public static void confirmationBox(Stage stage) {
        alertBox = new Alert(Alert.AlertType.CONFIRMATION);
        alertBox.setHeaderText("Confirmação de saída!!");
        alertBox.setContentText("Deseja mesmo sair?");
        Optional<ButtonType> result = alertBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            stage.close();
            alertBox.close();
        }
    }

    public static void loginSuccessfully(String login) {
        alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setHeaderText("Login com sucesso.");
        alertBox.setContentText("usuário " + login + " autenticado com sucesso.");
        alertBox.showAndWait();
    }

    public static void loginFailure() {
        alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setHeaderText("Falha de login.");
        alertBox.setContentText("usuário ou senha inválidos.");
        alertBox.showAndWait();
    }

    public static void confirmationReturnBox(Stage stage) {
        alertBox = new Alert(Alert.AlertType.CONFIRMATION);
        alertBox.setHeaderText("Confirmação de saída!!");
        alertBox.setContentText("Deseja mesmo retornar a tela anterior?");
        Optional<ButtonType> result = alertBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            stage.close();
            alertBox.close();
        }
    }
}
