package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.AlexaService;

@RestController
public class AlexaController {

	@Autowired
	private AlexaService alexaService;

	@GetMapping("users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
//		User user = new User(1, "Venky");
		User user = alexaService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
//		User u1 = new User(1, "Venky");
//		User u2 = new User(2, "ghouse");
//		User u3 = new User(3, "Siva");
//		List<User> listOfUsers = Arrays.asList(u1, u2, u3);
		List<User> listOfUsers = alexaService.getAllUsers();
		return ResponseEntity.ok(listOfUsers);
	}

	@PostMapping("users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = alexaService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}

	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
		User updatedUser = alexaService.updateUser(id, user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		alexaService.deleteUserById(id);

	}
}
