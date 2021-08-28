package com.example.springbootfirstweb.services;


import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user, Long userId) {
        if (!user.getPassword().equals(userRepository.findUserById(userId).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Transactional
    @Override
    public List<User> allUser() {

        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User findUser(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    @Override
    public User findUserByUsername(String name) {
        return userRepository.findUserByName(name);
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


}
