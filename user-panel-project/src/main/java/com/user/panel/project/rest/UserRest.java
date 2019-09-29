package com.user.panel.project.rest;

import com.user.panel.project.dao.User;
import com.user.panel.project.exception.UserNotFoundException;
import com.user.panel.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class UserRest {
	@Autowired
	private UserRepository userRepository;


	@GetMapping("/user")
	public java.util.List<User> findAll() {

	    return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public Optional<User> findById(@PathVariable Integer id) {
		userRepository.findById(id);
		if (userRepository.findById(id) == null) {
			throw new UserNotFoundException("id- " + id);
		}
		return userRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public User createUser(@RequestBody User user) {

	    return userRepository.save(user);
	}

	@PutMapping(value = "/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Integer id) {

	    return userRepository.save(user);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		if (userRepository.findById(id) == null) {
			throw new UserNotFoundException("id- " + id);
		}
		userRepository.deleteById(id);
	}
}
