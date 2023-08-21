module alura.hotel.challenge {
    requires javafx.fxml;
    requires javafx.controls;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;

    opens br.com.phss.controller;
    opens br.com.phss;
    opens br.com.phss.model;

    exports br.com.phss;
    exports br.com.phss.factory;
    exports br.com.phss.model;
    exports br.com.phss.dao;
    exports br.com.phss.controller;
    exports br.com.phss.utils;
}