package com.iremkoc.user_management_system.business.abstracts;

import java.util.List;

import com.iremkoc.user_management_system.entities.concretes.User;

public interface UserService {
    List<User> getAllUsers();
}
