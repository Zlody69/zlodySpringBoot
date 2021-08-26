package com.example.springbootfirstweb.dao;


import com.example.springbootfirstweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public User findUser(Long userId){
        return entityManager.find(User.class, userId);
    }

    public User findWithFetch(Long userId){
        return entityManager.createQuery("select user from User user join fetch user.roles where user.id=:id",User.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    @Override
    public void deleteUser(Long userId){
        entityManager.remove(entityManager.find(User.class, userId));
    }

    @Override
    public List<User> allUser(){
        return entityManager
                .createQuery("select user from User user")
                .getResultList();
    }

    @Override
    public void updateUser(User user, Long userId){
        user.setId(userId);
        entityManager.merge(user);
    }

    @Override
    public User findUserByUsername(String name){
        return entityManager.createQuery("select user from User user join fetch user.roles where user.name=:name",User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    @Override
    public User findUserByEmail(String email){
        System.out.println(email);
        User user = entityManager.createQuery("select user from User user join fetch user.roles where user.email=:email",User.class)
                .setParameter("email", email)
                .getSingleResult();
        System.out.println(user);
        return user;
    }
}
