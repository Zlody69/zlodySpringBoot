package com.example.springbootfirstweb.DAO;


import com.example.springbootfirstweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
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
        User fUser = entityManager.find(User.class, userId);
        return fUser;
    }

    @Override
    public void deleteUser(Long userId){
        User dUser = entityManager.find(User.class, userId);
        entityManager.remove(dUser);
    }

    @Override
    public List<User> allUser(){
        return entityManager
                .createQuery("select user from User user")
                .getResultList();
    }

    @Override
    public void updateUser(User user, Long userId){
        User updateUser = entityManager.find(User.class, userId);
        entityManager.detach(updateUser);
        updateUser.setName(user.getName());
        updateUser.setSurName(user.getSurName());
        updateUser.setAge(user.getAge());
        updateUser.setPassword(user.getPassword());
        updateUser.setRoles(user.getRoles());
        entityManager.merge(updateUser);
    }

    @Override
    public User findUserByUsername(String name){
        User fUSer = entityManager.createQuery("select user from User user where user.name=:name",User.class)
                .setParameter("name", name)
                .getSingleResult();
        return fUSer;
    }






}
