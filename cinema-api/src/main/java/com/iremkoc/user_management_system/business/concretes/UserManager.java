package com.iremkoc.user_management_system.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iremkoc.user_management_system.business.abstracts.UserService;
import com.iremkoc.user_management_system.dataAccess.abstracts.UserRepository;
import com.iremkoc.user_management_system.entities.concretes.User;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
