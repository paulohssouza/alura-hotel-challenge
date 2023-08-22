package br.com.phss.controller;

import br.com.phss.factory.ViewsFactory;
import br.com.phss.utils.DialogBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    public Button bookRecordButton;
    public Button searchButton;
    public Label dateLabel;
    public Button closeButton;
    private final ViewsFactory viewsFactory = new ViewsFactory();
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        dateLabel.setText("Hoje é " + localDate.format(formatter));
    }

    public void bookRecord(MouseEvent mouseEvent) {
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.close();
        viewsFactory.bookRecordView().show();
    }

    public void search(MouseEvent mouseEvent) {
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.close();
        viewsFactory.searchSystemView().show();
    }

    public void close(MouseEvent mouseEvent) {
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        DialogBox.confirmationBox(stage);
    }
}
