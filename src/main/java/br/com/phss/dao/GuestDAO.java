package br.com.phss.dao;

import br.com.phss.model.guest.Guest;
import br.com.phss.model.reservation.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;

public class GuestDAO {
    private final EntityManager entityManager;
    private Guest guest;

    public GuestDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Guest guest) {
        this.entityManager.persist(guest);
    }

    public void update(Guest guest, Reservation reservation) {
        this.guest = findByCPF(guest.getCpf());
        this.guest.addReservation(reservation);
        entityManager.merge(this.guest);
        entityManager.getTransaction().commit();
    }

    public Guest findByCPF(String cpf) {
        String jpql = "select g from Guest g where g.cpf = :cpf";
        try {
            return this.entityManager.createQuery(jpql, Guest.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    public List<Guest> findListGuest() {
        String jpql ="select g from Guest as g";
        return this.entityManager.createQuery(jpql, Guest.class).getResultList();
    }
}
