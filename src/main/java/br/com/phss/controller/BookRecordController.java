package br.com.phss.controller;

import br.com.phss.factory.ViewsFactory;
import br.com.phss.utils.DialogBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BookRecordController implements Initializable {
    public Button closeButton;
    public DatePicker checkInDatePicker;
    public DatePicker checkOutDatePicker;
    public TextField amountReservationTextField;
    public ComboBox paymentMethodComBox;
    public Button nextButton;
    public Button returnButton;
    private ViewsFactory viewsFactory = new ViewsFactory();
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void next(MouseEvent mouseEvent) {
    }

    public void returnWindow(MouseEvent mouseEvent) {
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        DialogBox.confirmationReturnBox(stage);
        viewsFactory.userMenuView().show();
    }

    public void close(MouseEvent mouseEvent) {
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        DialogBox.confirmationBox(stage);
    }
}
