package com.example.springbootfirstweb.services;

import com.example.springbootfirstweb.dao.UserDao;
import com.example.springbootfirstweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User loadUser = userDao.findUserByEmail(s);
        if(loadUser==null){
            throw new UsernameNotFoundException(String.format("users '%s' not found",s));
        }
        return loadUser;
    }
}
