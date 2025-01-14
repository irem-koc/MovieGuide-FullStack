package com.iremkoc.user_management_system.entities.concretes;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int statusCode;
    private String message;
    private String token;
    private String role;
    private String expirationTime;
    private String password;
    private String email;
    private String username;
    private User user;
}
