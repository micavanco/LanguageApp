package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public User findByUsername(String username) {
        List<User> users = entityManager.createQuery("SELECT u from User u where u.username=:username").setParameter("username", username).getResultList();
        if(users.size() > 0)
            return users.get(0);

        return null;
    }

    @Override
    @Transactional
    public User save(User user) {
        entityManager.persist(user);

        return user;
    }
}
