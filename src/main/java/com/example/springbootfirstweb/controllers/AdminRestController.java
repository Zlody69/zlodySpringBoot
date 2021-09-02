package com.example.springbootfirstweb.controllers;

import com.example.springbootfirstweb.model.Role;
import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.services.RoleService;
import com.example.springbootfirstweb.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/admin/api")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/user")
    public User curentUser(Principal principal){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    @GetMapping(value = "/users/{id}")
    public User findUser(@PathVariable("id")Long id){
        User user = userService.findUser(id);
        return user;
    }

    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user){
        Set<Role> roleSet = new HashSet<>();
        for (String role : user.getRolesDigit()){
            roleSet.add(roleService.findRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.addUser(user);
        return user;
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user){
        Set<Role> roleSet = new HashSet<>();
        for (String role : user.getRolesDigit()){
            roleSet.add(roleService.findRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.updateUser(user, user.getId());
        return user;
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "user deleted";
    }


    @GetMapping(value = "/users")
    public List<User> allUser(){
        List<User> userList = userService.allUser();
        return userList;
    }




}
