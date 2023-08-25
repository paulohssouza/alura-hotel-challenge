package br.com.phss.dao;

import br.com.phss.model.Guest;
import jakarta.persistence.EntityManager;

public class GuestDAO {
    private final EntityManager entityManager;

    public GuestDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Guest guest) {
        this.entityManager.persist(guest);
    }
}
