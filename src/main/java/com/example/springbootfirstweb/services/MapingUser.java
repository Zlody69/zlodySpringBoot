package com.example.springbootfirstweb.services;

import com.example.springbootfirstweb.dto.UserDto;
import com.example.springbootfirstweb.model.Role;
import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MapingUser {
    private final RoleRepository roleRepository;

    public MapingUser(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User mapDtoToUSer(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        Set<Role> roleSet = new HashSet<>();
        for (String role : userDto.getRoles()){
            roleSet.add(roleRepository.findRoleByName(role));
        }
        user.setRoles(roleSet);
        return user;
    }
}
