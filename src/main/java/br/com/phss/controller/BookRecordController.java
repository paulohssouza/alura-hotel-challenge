package br.com.phss.controller;

import br.com.phss.dao.GuestDAO;
import br.com.phss.dao.ReservationDAO;
import br.com.phss.factory.ViewsList;
import br.com.phss.model.guest.Guest;
import br.com.phss.model.reservation.PaymentForm;
import br.com.phss.model.reservation.Reservation;
import br.com.phss.model.service.CalculateAmountReservation;
import br.com.phss.model.service.ValidateGuest;
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
    public Button saveButton;
    public Button returnButton;
    public Label labelAmountReservation;
    public TextField textFiledGuestCPF;
    private GuestDAO guestDAO;
    private EntityManager entityManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkOutDatePicker.setDisable(true);
        paymentMethodComBox.setItems(paymentMethodsList());
    }

    public void save() {
        entityManager = JPAUtil.getEntityManager();
        guestDAO = new GuestDAO(entityManager);
        Guest guest = guestDAO.findByCPF(textFiledGuestCPF.getText());
        createReservation(guest);
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

    private void createReservation(Guest guest) {
        if(
                validateForm() && ValidateGuest.validateGuest(guest)
        ) {
            ReservationDAO reservationDAO = new ReservationDAO(entityManager);
            Reservation reservation = new Reservation(
                    checkInDatePicker.getValue(),
                    checkOutDatePicker.getValue(),
                    new BigDecimal(labelAmountReservation.getText()),
                    paymentMethodComBox.getValue().toString(),
                    guest
            );
            entityManager.getTransaction().begin();
            reservationDAO.insert(reservation);
            guestDAO.update(guest, reservation);
            entityManager.close();
        } else {
            DialogBox.validateFailureForm();
        }
    }

    private boolean validateForm() {
        return formDateIsNotNull(checkInDatePicker.getValue()) &&
                formDateIsNotNull(checkOutDatePicker.getValue()) &&
                formComboxIsNotNull(paymentMethodComBox.getValue()) &&
                formTextFieldLengthisValid(textFiledGuestCPF.getText(), 11);
    }
}
