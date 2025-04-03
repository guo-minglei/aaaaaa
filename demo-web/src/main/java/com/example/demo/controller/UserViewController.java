package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class UserViewController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "user-list";
    }
} 