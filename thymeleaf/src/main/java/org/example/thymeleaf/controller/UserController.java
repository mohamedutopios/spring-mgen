package org.example.thymeleaf.controller;


import org.example.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", new User("Bala",56,"active"));
        return "user";
    }


    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = Arrays
                .asList(
                        new User("John Connor",50,"active"),
                        new User("John Smith",40,"active"),
                        new User("Jane Doe",67,"inactive"),
                        new User("Jane Smith",50,"active"),
                new User("Nicolas Pitt",34,"inactive"));
        model.addAttribute("users", users);
        return "users";
    }






}
