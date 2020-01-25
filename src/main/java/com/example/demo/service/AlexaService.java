package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface AlexaService {
	
	public User saveUser(User user);

	public List<User> getAllUsers();

	public User getUserById(Integer id);

	public User updateUser(Integer id, User user);

	public void deleteUserById(Integer id);

}
