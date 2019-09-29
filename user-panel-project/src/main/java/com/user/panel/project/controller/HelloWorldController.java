
package com.user.panel.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.panel.project.dao.User;
import com.user.panel.project.repository.UserRepository;

@RestController
public class HelloWorldController {
	@Autowired
	private UserRepository repository;

	@GetMapping(path = "/hello-world-bean")
	public List<User> helloWorldBean() {
		return repository.findAll();

	}

}

