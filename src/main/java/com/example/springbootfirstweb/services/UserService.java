package com.example.springbootfirstweb.services;


import com.example.springbootfirstweb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void updateUser(User user, Long userId);

    List<User> allUser();

    User findUser(Long userId);

    void deleteUser(Long userId);

    User findUserByUsername(String name);
}