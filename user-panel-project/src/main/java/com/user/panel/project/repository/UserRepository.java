package com.user.panel.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.panel.project.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

}
