package com.example.springbootfirstweb.controllers;


import com.example.springbootfirstweb.model.User;
import com.example.springbootfirstweb.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String findUser(Model model, Principal principal){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("curent_user", user);
        return "user";
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, Principal principal){
        model.addAttribute("update_user", userService.findUserByUsername(principal.getName()));
        return "update_user";
    }

    @PutMapping(value ="/update")
    public String updateUser(@ModelAttribute("user")User user, Principal principal){
        userService.updateUser(user, userService.findUserByUsername(principal.getName()).getId());
        return "redirect:/user/";
    }
}
