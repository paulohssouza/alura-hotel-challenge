package br.com.phss.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static br.com.phss.utils.Constant.DAILYHOTEL;

public class CalculateAmountReservation {
    public static BigDecimal calculateAmountReservation(LocalDate checkInDate, LocalDate checkOutDate) {
        BigDecimal numberOfDays = BigDecimal.valueOf(checkInDate.until(checkOutDate, ChronoUnit.DAYS));
        return new BigDecimal(String.valueOf(DAILYHOTEL.multiply(numberOfDays)));
    }
}
