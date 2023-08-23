package br.com.phss.dao;

import br.com.phss.model.Reservation;
import jakarta.persistence.EntityManager;

public class ReservationDAO {
    private final EntityManager entityManager;

    public ReservationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Reservation reservation) {
        this.entityManager.persist(reservation);
    }
}
