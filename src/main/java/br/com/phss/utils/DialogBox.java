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
        confirmaationBox.setContentText("Deseja encerrar?");
        Optional<ButtonType> result = confirmaationBox.showAndWait();
        if(result.get() == ButtonType.OK) {
            stage.close();
            confirmaationBox.close();
        }
    }
}
