package com.iremkoc.user_management_system.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iremkoc.user_management_system.entities.concretes.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
