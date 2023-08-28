package br.com.phss.model.guest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestTableData {
    private Long id;
    private String name;
    private LocalDate birthday;
    private Country nationality;
    private String reservationIds;
}
