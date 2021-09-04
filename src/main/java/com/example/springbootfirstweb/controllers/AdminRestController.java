package com.example.springbootfirstweb.controllers;

import com.example.springbootfirstweb.dto.UserDto;
import com.example.springbootfirstweb.model.Role;
import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.services.MapingUser;
import com.example.springbootfirstweb.services.RoleService;
import com.example.springbootfirstweb.services.UserService;
import org.springframework.http.ResponseEntity;
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
    private final MapingUser mapingUser;

    public AdminRestController(UserService userService, RoleService roleService, MapingUser mapingUser) {
        this.userService = userService;
        this.roleService = roleService;
        this.mapingUser = mapingUser;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> curentUser(Principal principal){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> findUser(@PathVariable("id")Long id){
        User user = userService.findUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
        User user = mapingUser.mapDtoToUSer(userDto);
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto){
        User user = mapingUser.mapDtoToUSer(userDto);
        userService.updateUser(user, user.getId());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("user deleted");
    }


    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> allUser(){
        List<User> userList = userService.allUser();
        return ResponseEntity.ok().body(userList);
    }




}
