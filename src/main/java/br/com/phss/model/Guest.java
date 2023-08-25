package br.com.phss.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(length = 11)
    private String cpf;
    private LocalDate birthday;
    private Country nationality;
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;
    @OneToMany(mappedBy = "guest", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Reservation> reservationList;

    public Guest(String name, String lastName, String cpf, LocalDate birthday, Country nationality, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthday = birthday;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.reservationList = null;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", nationality='" + nationality + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reservationList=" + reservationList +
                '}';
    }
}
