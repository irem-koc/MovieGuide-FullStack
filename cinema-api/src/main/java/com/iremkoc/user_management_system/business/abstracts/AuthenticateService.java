package com.iremkoc.user_management_system.business.abstracts;

import com.iremkoc.user_management_system.business.requests.LoginRequest;
import com.iremkoc.user_management_system.entities.concretes.Response;
import com.iremkoc.user_management_system.entities.concretes.User;

public interface AuthenticateService {
    Response register(User user);

    Response login(LoginRequest loginRequest);
}
