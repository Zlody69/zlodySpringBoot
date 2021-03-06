package com.example.springbootfirstweb.controllers;


import com.example.springbootfirstweb.model.Role;
import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.services.RoleService;
import com.example.springbootfirstweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping( value = "/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String allUser(Model model, Principal principal){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("admin",user);
        model.addAttribute("users",userService.allUser());
        model.addAttribute("allRole", roleService.allRoles());
        return "all_user";
    }

    @GetMapping(value = "/{id}")
    public String findUser(Model model, @PathVariable("id")Long id){
        model.addAttribute("curent_user", userService.findUser(id));
        return "user";
    }


    @GetMapping(value = "/create")
    public String addUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("allRole", roleService.allRoles());
        return "create_user";
    }

    @PutMapping(value ="/{id}")
    public String updateUser(@ModelAttribute("user")User user,
                             @PathVariable("id")Long id,
                             @RequestParam("role") String[] roles){
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles){
            roleSet.add(roleService.findRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.updateUser(user, id);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user")User user,
                             @RequestParam("role") String[] roles){
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles){
            roleSet.add(roleService.findRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.addUser(user);
        return "redirect:/admin";
    }
}
