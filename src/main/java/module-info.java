module alura.hotel.challenge {
    requires javafx.fxml;
    requires javafx.controls;

    opens br.com.phss.controller to javafx.fxml;

    exports br.com.phss;
    exports br.com.phss.factory;
}