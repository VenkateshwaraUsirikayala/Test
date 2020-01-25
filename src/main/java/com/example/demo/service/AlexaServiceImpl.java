package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Alexadao;
import com.example.demo.model.User;

@Service
public class AlexaServiceImpl implements AlexaService {

	@Autowired
	private Alexadao alexaDao;

	@Override
	public User saveUser(User user) {
		User savedUser = alexaDao.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		Iterable<User> listOfUsers = alexaDao.findAll();
		List<User> users = new ArrayList<>();
		for (User user : listOfUsers) {
			users.add(user);
		}
		return users;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> optionalUser = alexaDao.findById(id);
//		if(optionalUser.isPresent())
		return optionalUser.orElseGet(() -> new User());
	}

	@Override
	public User updateUser(Integer id, User user) {
		Optional<User> optionalUser = alexaDao.findById(id);
		if (optionalUser.isPresent()) {
			User savedUser = optionalUser.get();
			savedUser.setName(user.getName());
			alexaDao.save(savedUser);
			return savedUser;
		}
		return user;
	}

	@Override
	public void deleteUserById(Integer id) {
		alexaDao.deleteById(id);
	}

}
