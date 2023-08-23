package br.com.phss.utils;

import br.com.phss.factory.ChangeScene;
import br.com.phss.factory.ViewsList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogBox {
    private static Alert alertBox;
    public static void confirmationBox(ViewsList view) {
        alertBox = new Alert(Alert.AlertType.CONFIRMATION);
        alertBox.setHeaderText("Confirmação de saída!!");
        alertBox.setContentText("Deseja mesmo sair?");
        Optional<ButtonType> result = alertBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            alertBox.close();
            ChangeScene.changeScene(view);
        }
    }

    public static void loginSuccessfully(String login, ViewsList view) {
        alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setHeaderText("Login com sucesso.");
        alertBox.setContentText("usuário " + login + " autenticado com sucesso.");
        Optional<ButtonType> result = alertBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            alertBox.close();
            ChangeScene.changeScene(view);
        }
    }

    public static void loginFailure() {
        alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setHeaderText("Falha de login.");
        alertBox.setContentText("usuário ou senha inválidos.");
        alertBox.showAndWait();
    }

    public static void confirmationReturnBox(ViewsList view) {
        alertBox = new Alert(Alert.AlertType.CONFIRMATION);
        alertBox.setHeaderText("Confirmação de saída!!");
        alertBox.setContentText("Deseja mesmo retornar a tela anterior?");
        Optional<ButtonType> result = alertBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            ChangeScene.changeScene(view);
            alertBox.close();
        }
    }
}
