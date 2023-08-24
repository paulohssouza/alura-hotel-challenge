package br.com.phss.model.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAmountReservationTest {

    private final LocalDate checkInDate = LocalDate.now();
    private final LocalDate checkOutDate = LocalDate.now().plusDays(5L);
    private final BigDecimal amount = new BigDecimal(500);
    @Test
    void testObjectReturnInCalculateAmountReservationSuccess() {
        assertEquals(amount.getClass(), CalculateAmountReservation.calculateAmountReservation(checkInDate, checkOutDate).getClass());
    }

    @Test
    void calculateAmountReservation() {
        assertEquals(amount, CalculateAmountReservation.calculateAmountReservation(checkInDate, checkOutDate));
    }
}