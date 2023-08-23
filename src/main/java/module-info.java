module alura.hotel.challenge {
    opens br.com.phss.controller;
    opens br.com.phss;
    opens br.com.phss.model;

    exports br.com.phss;
    exports br.com.phss.factory;
    exports br.com.phss.model;
    exports br.com.phss.dao;
    exports br.com.phss.controller;
    exports br.com.phss.utils;

    requires javafx.fxml;
    requires javafx.controls;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
}