package com.iremkoc.user_management_system.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iremkoc.user_management_system.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
