package br.com.phss.controller;

import br.com.phss.factory.ViewsList;
import br.com.phss.model.guest.Country;
import br.com.phss.model.guest.Guest;
import br.com.phss.model.guest.GuestTableData;
import br.com.phss.model.reservation.PaymentForm;
import br.com.phss.model.reservation.ReservationTableData;
import br.com.phss.model.service.GenerateListTable;
import br.com.phss.utils.DialogBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SearchSystemController implements Initializable {
    @FXML
    public Button searchButton;
    @FXML
    public TextField searchTextField;
    @FXML
    public Button updateButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button returnButton;
    @FXML
    public Button closeButton;
    @FXML
    public TableColumn<ReservationTableData, Long> idColumnReservation;
    @FXML
    public TableColumn<ReservationTableData, LocalDate> checkinColumn;
    @FXML
    public TableColumn<ReservationTableData, LocalDate> checkoutColumn;
    @FXML
    public TableColumn<ReservationTableData, BigDecimal> amountColumn;
    @FXML
    public TableColumn<ReservationTableData, PaymentForm> paymentFormColumn;
    @FXML
    public TableColumn<ReservationTableData, Guest> guestColumn;
    @FXML
    public TableView<ReservationTableData> reservationTable;
    @FXML
    public Tab reservationTAB;
    @FXML
    public TableView<GuestTableData> guestTable;
    @FXML
    public TableColumn<GuestTableData, Long> idColumnGuest;
    @FXML
    public TableColumn<GuestTableData, String> nameColumn;
    @FXML
    public TableColumn<GuestTableData, LocalDate> birthdayColumn;
    @FXML
    public TableColumn<GuestTableData, Country> nationalityColumn;
    @FXML
    public TableColumn<GuestTableData, String> reservationIdsColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateReservationTable();
        populateGuestTable();
    }

    public void search(ActionEvent event) {
    }

    public void update(ActionEvent event) {
    }

    public void delete(ActionEvent event) {
    }

    public void returnWindow() {
        DialogBox.confirmationBox(ViewsList.USERMENU);
    }

    public void close() {
        DialogBox.confirmationBox(ViewsList.USERMENU);
    }

    private void populateReservationTable() {
        idColumnReservation.setCellValueFactory(new PropertyValueFactory<>("id"));
        checkinColumn.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        checkoutColumn.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentFormColumn.setCellValueFactory(new PropertyValueFactory<>("paymentForm"));
        guestColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        ObservableList<ReservationTableData> reservationTableDataObservableList = FXCollections.observableList(GenerateListTable.createReservationTableDataList());
        reservationTable.setItems(reservationTableDataObservableList);
    }

    private void populateGuestTable() {
        idColumnGuest.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        reservationIdsColumn.setCellValueFactory(new PropertyValueFactory<>("reservationIds"));
        ObservableList<GuestTableData> guestTableDataObservableList = FXCollections.observableList(GenerateListTable.createGuestTableDataList());
        guestTable.setItems(guestTableDataObservableList);
    }
}
