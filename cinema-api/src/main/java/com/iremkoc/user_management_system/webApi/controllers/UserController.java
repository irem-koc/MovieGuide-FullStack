package com.iremkoc.user_management_system.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iremkoc.user_management_system.business.concretes.UserManager;
import com.iremkoc.user_management_system.entities.concretes.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userManager.getAllUsers();
    }
}
