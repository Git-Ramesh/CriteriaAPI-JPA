package com.rs.criteria.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.criteria.app.model.User;

public interface UserRepo extends JpaRepository<User, String>, UserRepoAdditional {
	
}
