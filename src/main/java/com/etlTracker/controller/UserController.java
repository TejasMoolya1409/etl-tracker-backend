package com.etlTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etlTracker.beans.CreateUserRequest;
import com.etlTracker.beans.LoginRequest;
import com.etlTracker.entity.User;
import com.etlTracker.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public User create(@RequestBody CreateUserRequest request) {
		return userService.createUser(request);
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PostMapping("/login")
	public User login(@RequestBody LoginRequest request) {
		return userService.login(request.getEmail(), request.getPassword());
	}
}
