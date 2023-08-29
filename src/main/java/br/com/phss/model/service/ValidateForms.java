package br.com.phss.model.service;

import br.com.phss.model.TypeSearch;
import br.com.phss.utils.DialogBox;

import java.time.LocalDate;
import java.util.Objects;

public class ValidateForms {
    public static boolean formDateIsNotNull(LocalDate date) {
        return date != null;
    }

    public static boolean formComboxIsNotNull(Object object) {return object != null;}

    public static boolean formTextFieldIsValid(String text) {
        return !text.isBlank();
    }

    public static boolean formTextFieldLengthisValid(String text, int length) {
        return !text.isBlank() && text.length() == length;
    }

    public static boolean formTextFieldSearchValid(TypeSearch typeSearch) {
        return typeSearch != null;
    }

}
