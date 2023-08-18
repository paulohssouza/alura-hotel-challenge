package br.com.phss.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogBox {
    public static void confirmationBox() {
        Alert confirmaationBox = new Alert(Alert.AlertType.CONFIRMATION);
        confirmaationBox.setHeaderText("Confirmação de saída!");
        confirmaationBox.setContentText("Deseja encerrar o aplicativo?");
        Optional<ButtonType> result = confirmaationBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            confirmaationBox.close();
        }
    }
}
