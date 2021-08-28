package com.example.springbootfirstweb.services;


import com.example.springbootfirstweb.model.Role;
import com.example.springbootfirstweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public List<Role> allRoles(){
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }
}
