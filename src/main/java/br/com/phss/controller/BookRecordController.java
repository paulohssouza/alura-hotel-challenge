package br.com.phss.controller;

import br.com.phss.factory.ViewsList;
import br.com.phss.model.PaymentForm;
import br.com.phss.model.Reservation;
import br.com.phss.utils.DialogBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookRecordController implements Initializable {
    public Button closeButton;
    public DatePicker checkInDatePicker;
    public DatePicker checkOutDatePicker;
    public TextField amountReservationTextField;
    public ComboBox paymentMethodComBox;
    public Button nextButton;
    public Button returnButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentMethodComBox.setItems(paymentMethodsList());
    }

    public void next() {
        Reservation reservation = new Reservation(
                checkInDatePicker.getValue(),
                checkOutDatePicker.getValue(),
                new BigDecimal(amountReservationTextField.getText()),
                paymentMethodComBox.getValue().toString()
        );
        System.out.println(reservation);
    }

    public void returnWindow() {
        DialogBox.confirmationReturnBox(ViewsList.USERMENU);
    }

    public void close() {
        DialogBox.confirmationBox(ViewsList.USERMENU);
    }

    private ObservableList<String> paymentMethodsList() {
        List<String> paymentMethodsList = new ArrayList<>();
        paymentMethodsList.add(PaymentForm.CREDITO.toString());
        paymentMethodsList.add(PaymentForm.DEBITO.toString());
        paymentMethodsList.add(PaymentForm.PIX.toString());
        paymentMethodsList.add(PaymentForm.DINHEIRO.toString());
        return FXCollections.observableList(paymentMethodsList);
    }
}
