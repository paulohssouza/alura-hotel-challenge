package br.com.phss.controller;

import br.com.phss.dao.ReservationDAO;
import br.com.phss.factory.ViewsList;
import br.com.phss.model.PaymentForm;
import br.com.phss.model.Reservation;
import br.com.phss.model.service.CalculateAmountReservation;
import br.com.phss.utils.DialogBox;
import static br.com.phss.model.service.ValidateForms.*;

import br.com.phss.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BookRecordController implements Initializable {
    public Button closeButton;
    public DatePicker checkInDatePicker;
    public DatePicker checkOutDatePicker;
    public ComboBox<PaymentForm> paymentMethodComBox;
    public Button nextButton;
    public Button returnButton;
    public Label labelAmountReservation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkOutDatePicker.setDisable(true);
        paymentMethodComBox.setItems(paymentMethodsList());
    }

    public void next() {
        createReservation();
    }

    public void returnWindow() {
        DialogBox.confirmationReturnBox(ViewsList.USERMENU);
    }

    public void close() {
        DialogBox.confirmationBox(ViewsList.USERMENU);
    }

    private ObservableList<PaymentForm> paymentMethodsList() {
        List<PaymentForm> paymentMethodsList = new ArrayList<>(Arrays.asList(PaymentForm.values()));
        return FXCollections.observableList(paymentMethodsList);
    }

    public void checkInDateInput() {
        checkOutDatePicker.setDisable(false);
    }

    public void checkOutDateInput() {
        String amount = CalculateAmountReservation
                .calculateAmountReservation(
                        checkInDatePicker.getValue(),
                        checkOutDatePicker.getValue())
                .toString();
        labelAmountReservation.setText(amount);
    }

    private void createReservation() {
        if(
                formDateIsNotNull(checkInDatePicker.getValue()) &&
                        formDateIsNotNull(checkOutDatePicker.getValue()) &&
                        formComboxIsNotNull(paymentMethodComBox.getValue())
        ) {
            EntityManager entityManager = JPAUtil.getEntityManager();
            ReservationDAO reservationDAO = new ReservationDAO(entityManager);
            Reservation reservation = new Reservation(
                    checkInDatePicker.getValue(),
                    checkOutDatePicker.getValue(),
                    new BigDecimal(labelAmountReservation.getText()),
                    paymentMethodComBox.getValue().toString()
            );
            entityManager.getTransaction().begin();
            reservationDAO.insert(reservation);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            DialogBox.validateFailureForm();
        }
    }
}
