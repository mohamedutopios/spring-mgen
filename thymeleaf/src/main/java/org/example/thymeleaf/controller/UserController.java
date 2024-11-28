package org.example.thymeleaf.controller;


import org.example.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping
    public String user(Model model) {
        model.addAttribute("user", new User("Bala",56,"active"));
        return "user";
    }







}
