package br.com.phss.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entry_date")
    private LocalDate entryDate;
    @Column(name = "departure_date")
    private LocalDate departureDate;
    private BigDecimal amount;
    private PaymentForm paymentForm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Reservation(LocalDate entryDate, LocalDate departureDate, BigDecimal amount, PaymentForm paymentForm, Guest guest) {
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.amount = amount;
        this.paymentForm = paymentForm;
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", entryDate=" + entryDate +
                ", departureDate=" + departureDate +
                ", amount=" + amount +
                ", paymentForm=" + paymentForm +
                ", guest=" + guest +
                '}';
    }
}
