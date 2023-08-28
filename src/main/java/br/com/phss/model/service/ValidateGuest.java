package br.com.phss.model.service;

import br.com.phss.model.guest.Guest;
import br.com.phss.utils.DialogBox;

public class ValidateGuest {
    public static boolean validateGuest(Guest guest) {
        if (guest == null) {
            DialogBox.validateGuestFailure();
        }
        return guest != null;
    }
}
