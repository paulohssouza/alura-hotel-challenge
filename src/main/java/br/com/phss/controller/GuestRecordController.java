package br.com.phss.controller;

import br.com.phss.dao.GuestDAO;
import br.com.phss.factory.ViewsList;
import br.com.phss.model.Country;
import br.com.phss.model.Guest;
import br.com.phss.utils.DialogBox;
import br.com.phss.model.service.FormsConfiguration;
import static br.com.phss.model.service.ValidateForms.*;

import br.com.phss.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class GuestRecordController implements Initializable {
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldLastName;
    @FXML
    public DatePicker datePickerBirthday;
    @FXML
    public TextField textFieldPhoneNumber;
    @FXML
    public ComboBox<Country> comboBoxNacionality;
    @FXML
    public Button buttonSave;
    @FXML
    public TextField textFieldCPF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxNacionality.setItems(nacionalityList());
        FormsConfiguration.limitTextField(textFieldCPF, 11);
        FormsConfiguration.limitTextField(textFieldPhoneNumber, 11);
    }

    public void save(ActionEvent event) {
        createGuest();
        DialogBox.inssertSuccessfully();
        DialogBox.confirmationNewInsertion(ViewsList.USERMENU);
        textFieldName.clear();
        textFieldLastName.clear();
        textFieldCPF.clear();
        datePickerBirthday.getEditor().clear();
        comboBoxNacionality.setValue(null);
        textFieldPhoneNumber.clear();
    }

    private ObservableList<Country> nacionalityList() {
        List<Country> countryList = new ArrayList<>(Arrays.asList(Country.values()));
        return FXCollections.observableList(countryList);
    }

    private void createGuest() {
        if(
              formTextFieldIsValid(textFieldName.getText()) &&
              formTextFieldIsValid(textFieldLastName.getText()) &&
              formTextFieldLengthisValid(textFieldCPF.getText(), 11) &&
              formDateIsNotNull(datePickerBirthday.getValue()) &&
              formComboxIsNotNull(comboBoxNacionality.getValue()) &&
              formTextFieldLengthisValid(textFieldPhoneNumber.getText(), 11)
        ) {
            EntityManager entityManager = JPAUtil.getEntityManager();
            GuestDAO guestDAO = new GuestDAO(entityManager);
            Guest guest = new Guest(
                    textFieldName.getText(),
                    textFieldLastName.getText(),
                    textFieldCPF.getText(),
                    datePickerBirthday.getValue(),
                    comboBoxNacionality.getValue(),
                    textFieldPhoneNumber.getText()
            );
            entityManager.getTransaction().begin();
            guestDAO.insert(guest);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            DialogBox.validateFailureForm();
        }
    }
}
