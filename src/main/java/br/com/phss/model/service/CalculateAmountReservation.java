package br.com.phss.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateAmountReservation {
    public static BigDecimal calculateAmountReservation(LocalDate checkInDate, LocalDate checkOutDate) {
        BigDecimal numberOfDays = BigDecimal.valueOf(checkInDate.until(checkOutDate, ChronoUnit.DAYS));
        BigDecimal dailyRate = new BigDecimal("100.00");
        return new BigDecimal(String.valueOf(dailyRate.multiply(numberOfDays)));
    }
}
