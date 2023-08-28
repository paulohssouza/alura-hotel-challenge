package br.com.phss.model.service;

import br.com.phss.dao.GuestDAO;
import br.com.phss.model.Guest;
import br.com.phss.utils.JPAUtil;
import jakarta.persistence.EntityManager;

public class ValidateGuest {
    private Guest guest;
    private GuestDAO guestDAO;
    private EntityManager entityManager;
    public Guest validateGuest(String cpf) {
        entityManager = JPAUtil.getEntityManager();
        guestDAO = new GuestDAO(entityManager);
        guest = guestDAO.findByCPF(cpf);
        return guest;
    }
}
