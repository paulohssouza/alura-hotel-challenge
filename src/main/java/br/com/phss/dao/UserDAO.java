package br.com.phss.dao;

import br.com.phss.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User findByLogin(String login) {
        String jpql = "select u from User u where u.login = :login";
        try {
            return this.entityManager.createQuery(jpql, User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
