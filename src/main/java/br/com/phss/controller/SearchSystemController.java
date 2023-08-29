package br.com.phss.controller;

import br.com.phss.dao.GuestDAO;
import br.com.phss.dao.ReservationDAO;
import br.com.phss.factory.ViewsList;
import br.com.phss.model.TypeSearch;
import br.com.phss.model.guest.Country;
import br.com.phss.model.guest.Guest;
import br.com.phss.model.guest.GuestTableData;
import br.com.phss.model.reservation.PaymentForm;
import br.com.phss.model.reservation.Reservation;
import br.com.phss.model.reservation.ReservationTableData;
import br.com.phss.model.service.GenerateListTable;
import br.com.phss.model.service.ValidateForms;
import br.com.phss.utils.DialogBox;
import br.com.phss.utils.JPAUtil;
import jakarta.persistence.EntityManager;
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
import java.util.*;

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
    @FXML
    public ComboBox<TypeSearch> comboBoxTypeSearch;
    private EntityManager entityManager;
    private GuestDAO guestDAO;
    private Guest guest;
    private GuestTableData guestTableData;
    private ReservationDAO reservationDAO;
    private Reservation reservation;
    ReservationTableData reservationTableData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateReservationTable();
        populateGuestTable();
        comboBoxTypeSearch.setItems(populateComboBoxTypeSearch());
        searchTextField.setText("");
    }

    public void search() {
        searchAction();
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
        initializeReservationTable();
        ObservableList<ReservationTableData> reservationTableDataObservableList = FXCollections.observableList(GenerateListTable.createReservationTableDataList());
        reservationTable.setItems(reservationTableDataObservableList);
    }

    private void populateGuestTable() {
        initializeGuestTable();
        ObservableList<GuestTableData> guestTableDataObservableList = FXCollections.observableList(GenerateListTable.createGuestTableDataList());
        guestTable.setItems(guestTableDataObservableList);
    }

    private ObservableList<TypeSearch> populateComboBoxTypeSearch() {
        List<TypeSearch> typeSearchList = new ArrayList<>(Arrays.asList(TypeSearch.values()));
        return FXCollections.observableList(typeSearchList);
    }

    private void searchAction() {
        if(ValidateForms.formTextFieldSearchValid(comboBoxTypeSearch.getValue())) {
            switch (comboBoxTypeSearch.getValue()) {
                case ID: {
                    if(!Objects.equals(searchTextField.getText(), "")){
                        entityManager = JPAUtil.getEntityManager();
                        reservationDAO = new ReservationDAO(entityManager);
                        try {
                            reservation = reservationDAO.findByID(Long.valueOf(searchTextField.getText()));
                        } catch (Exception exception) {
                            DialogBox.dialogBoxInformation("Aviso!", "Informe um id válido.(Número do tipo inteiro.)");
                        }
                        reservationTable.getSelectionModel().select(null);
                        createReservationTableData();
                        List<ReservationTableData> reservationTableDataList = new ArrayList<>();
                        reservationTableDataList.add(reservationTableData);
                        reservationTable.setItems(FXCollections.observableList(reservationTableDataList));
                        entityManager.close();
                        break;
                    } else {
                        populateReservationTable();
                    }
                }
                case CPF: {
                    if(!Objects.equals(searchTextField.getText(), "")) {
                        entityManager = JPAUtil.getEntityManager();
                        guestDAO = new GuestDAO(entityManager);
                        try {
                            guest = guestDAO.findByCPF(searchTextField.getText());
                        } catch (Exception exception) {
                            DialogBox.dialogBoxInformation("Aviso!", "Digite um cpf válido.");
                        }
                        guestTable.getSelectionModel().select(null);
                        createGuestTableData();
                        List<GuestTableData> guestTableDataList = new ArrayList<>();
                        guestTableDataList.add(guestTableData);
                        guestTable.setItems(FXCollections.observableList(guestTableDataList));
                        entityManager.close();
                    } else {
                        populateGuestTable();
                    }
                }
            }
        } else {
            DialogBox.dialogBoxInformation("Aviso!", "Selecione uma opção: ID ou CPF");
        }
    }

    private void initializeGuestTable() {
        idColumnGuest.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        reservationIdsColumn.setCellValueFactory(new PropertyValueFactory<>("reservationIds"));
    }

    private void initializeReservationTable() {
        idColumnReservation.setCellValueFactory(new PropertyValueFactory<>("id"));
        checkinColumn.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        checkoutColumn.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentFormColumn.setCellValueFactory(new PropertyValueFactory<>("paymentForm"));
        guestColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));
    }

    private void createReservationTableData() {
        try {
            reservationTableData = new ReservationTableData(
                    reservation.getId(),
                    reservation.getEntryDate(),
                    reservation.getDepartureDate(),
                    reservation.getAmount(),
                    reservation.getPaymentForm(),
                    (reservation.getGuest().getName() + " " + reservation.getGuest().getLastName())
            );
        } catch (NullPointerException nullPointerException) {
            DialogBox.validateReservationFailure();
        }
    }

    private void createGuestTableData() {
        try {
            guestTableData = new GuestTableData(
                    guest.getId(),
                    (guest.getName() + " " + guest.getLastName()),
                    guest.getBirthday(),
                    guest.getNationality(),
                    GenerateListTable.generateStringReservationIds(guest)
            );
        } catch (NullPointerException nullPointerException) {
            DialogBox.validateGuestFailure();
        }
    }
}
