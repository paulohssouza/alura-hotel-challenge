package br.com.phss.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTableData {
    private Long id;
    private LocalDate checkin;
    private LocalDate checkout;
    private BigDecimal amount;
    private String paymentForm;
    private String guestName;
}
