package com.iremkoc.user_management_system.business.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String username;
    private String role;

}
