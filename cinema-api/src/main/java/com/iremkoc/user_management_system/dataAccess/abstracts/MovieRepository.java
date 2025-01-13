package com.iremkoc.user_management_system.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iremkoc.user_management_system.entities.concretes.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
