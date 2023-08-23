package br.com.phss.controller;

import br.com.phss.factory.ViewsList;
import br.com.phss.model.PaymentForm;
import br.com.phss.model.Reservation;
import br.com.phss.model.service.CalculateAmountReservation;
import br.com.phss.utils.DialogBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookRecordController implements Initializable {
    public Button closeButton;
    public DatePicker checkInDatePicker;
    public DatePicker checkOutDatePicker;
    public ComboBox paymentMethodComBox;
    public Button nextButton;
    public Button returnButton;
    public Label labelAmountReservation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkOutDatePicker.setDisable(true);
        paymentMethodComBox.setItems(paymentMethodsList());
    }

    public void next() {
        Reservation reservation = new Reservation(
                checkInDatePicker.getValue(),
                checkOutDatePicker.getValue(),
                new BigDecimal(labelAmountReservation.getText()),
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

    public void checkInDateInput(ActionEvent inputMethodEvent) {
        checkOutDatePicker.setDisable(false);
    }

    public void checkOutDateInput(ActionEvent inputMethodEvent) {
        String amount = CalculateAmountReservation
                .calculateAmountReservation(
                        checkInDatePicker.getValue(),
                        checkOutDatePicker.getValue())
                .toString();
        labelAmountReservation.setText(amount);
    }
}
