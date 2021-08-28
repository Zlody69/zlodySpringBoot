package com.example.springbootfirstweb.services;

import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User loadUser = userRepository.findUserByEmail(s);
        if(loadUser==null){
            throw new UsernameNotFoundException(String.format("users '%s' not found",s));
        }
        return loadUser;
    }
}
