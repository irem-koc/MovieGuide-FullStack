package com.iremkoc.user_management_system.business.abstracts;

import com.iremkoc.user_management_system.business.requests.LoginRequest;
import com.iremkoc.user_management_system.business.requests.RegisterRequest;
import com.iremkoc.user_management_system.entities.concretes.Response;

public interface AuthenticateService {
    Response register(RegisterRequest registerRequest);

    Response login(LoginRequest loginRequest);
}
