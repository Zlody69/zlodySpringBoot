package com.example.springbootfirstweb.dao;



import com.example.springbootfirstweb.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    User findUser(Long userId);

    void deleteUser(Long userId);

    List<User> allUser();

    void updateUser(User user, Long userId);

    User findUserByUsername(String name);
}
