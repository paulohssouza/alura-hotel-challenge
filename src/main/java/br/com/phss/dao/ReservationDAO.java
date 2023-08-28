package br.com.phss.dao;

import br.com.phss.model.reservation.Reservation;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ReservationDAO {
    private final EntityManager entityManager;

    public ReservationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Reservation reservation) {
        this.entityManager.persist(reservation);
    }

    public Reservation findByID(Long id) {
        return this.entityManager.find(Reservation.class, id);
    }

    public List<Reservation> findListReservation() {
        String jpql = "select r from Reservation as r";
        return this.entityManager.createQuery(jpql, Reservation.class).getResultList();
    }
}
