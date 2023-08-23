package br.com.phss.controller;

import br.com.phss.factory.ChangeScene;
import br.com.phss.factory.ViewsList;
import br.com.phss.utils.DialogBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    public Button bookRecordButton;
    public Button searchButton;
    public Label dateLabel;
    public Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        dateLabel.setText("Hoje é " + localDate.format(formatter));
    }

    public void bookRecord() {
        ChangeScene.changeScene(ViewsList.BOOKRECORD).show();
    }

    public void search() {
        ChangeScene.changeScene(ViewsList.SEARCHSYSTEM).show();
    }

    public void close() {
        DialogBox.confirmationBox(ViewsList.MAIN);
    }
}
