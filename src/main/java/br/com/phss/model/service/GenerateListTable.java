package br.com.phss.model.service;

import br.com.phss.dao.GuestDAO;
import br.com.phss.dao.ReservationDAO;
import br.com.phss.model.guest.Guest;
import br.com.phss.model.guest.GuestTableData;
import br.com.phss.model.reservation.Reservation;
import br.com.phss.model.reservation.ReservationTableData;
import br.com.phss.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class GenerateListTable {
    private static final EntityManager entityManager = JPAUtil.getEntityManager();

    public static List<ReservationTableData> createReservationTableDataList() {
        ReservationDAO reservationDAO = new ReservationDAO(entityManager);
        List<ReservationTableData> reservationTableDataList = new ArrayList<>();
        reservationDAO.findListReservation().forEach(reservation -> {
            reservationTableDataList.add(new ReservationTableData(
                    reservation.getId(),
                    reservation.getEntryDate(),
                    reservation.getDepartureDate(),
                    reservation.getAmount(),
                    reservation.getPaymentForm(),
                    (reservation.getGuest().getName() + " " + reservation.getGuest().getLastName())
            ));
        });
        return reservationTableDataList;
    }

    public static List<GuestTableData> createGuestTableDataList() {
        GuestDAO guestDAO = new GuestDAO(entityManager);
        List<GuestTableData> guestTableDataList = new ArrayList<>();
        guestDAO.findListGuest().forEach(guest -> {
            guestTableDataList.add(new GuestTableData(
                    guest.getId(),
                    (guest.getName() + " " + guest.getLastName()),
                    guest.getBirthday(),
                    guest.getNationality(),
                    generateStringReservationIds(guest)
            ));
        });
        return guestTableDataList;
    }

    private static String generateStringReservationIds(Guest guest) {
        String ids = "IDs: ";
        for (Reservation reservation : guest.getReservationList()
             )
            ids = ids + (reservation.getId() + " / ");
        return ids;
    }
}
