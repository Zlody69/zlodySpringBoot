package com.example.springbootfirstweb.controllers;

import com.example.springbootfirstweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class LogController {
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }


    @GetMapping(value = "/default")
    public String redirRole(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }

}
