package com.etlTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etlTracker.beans.CreateUserRequest;
import com.etlTracker.entity.User;
import com.etlTracker.exceptions.UserNotFoundException;
import com.etlTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User createUser(CreateUserRequest request) {

		// basic validation
		userRepository.findByEmail(request.getEmail()).ifPresent(u -> {
			throw new RuntimeException("Email already exists");
		});

		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());

		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public User login(String email, String password) {

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));

		if (!user.getPassword().equals(password)) {
			throw new UserNotFoundException();
		}

		return user;
	}
}
