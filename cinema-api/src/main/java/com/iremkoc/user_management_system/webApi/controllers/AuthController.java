package com.iremkoc.user_management_system.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iremkoc.user_management_system.business.concretes.AuthenticateManager;
import com.iremkoc.user_management_system.business.requests.LoginRequest;
import com.iremkoc.user_management_system.business.requests.RegisterRequest;
import com.iremkoc.user_management_system.entities.concretes.Response;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticateManager authenticateManager;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest) {
        Response response = authenticateManager.register(registerRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        Response response = authenticateManager.login(loginRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
