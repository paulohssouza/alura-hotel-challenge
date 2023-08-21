package br.com.phss.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDate birthday;
    private String nationality;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservationList;

    public Guest(String name, String lastName, LocalDate birthday, String nationality, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
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
