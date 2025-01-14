package com.iremkoc.user_management_system.business.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

}
