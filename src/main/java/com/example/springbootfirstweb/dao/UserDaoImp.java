package com.example.springbootfirstweb.dao;


import com.example.springbootfirstweb.model.User;
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
        entityManager.detach(entityManager.find(User.class, userId));
        entityManager.merge(user);
    }

    @Override
    public User findUserByUsername(String name){
        return entityManager.createQuery("select user from User user join fetch user.roles where user.name=:name",User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
