package com.keerthana.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keerthana.demo.model.User;
import com.keerthana.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	// to insert the data
	@PostMapping("/doUserInsert")
	public User insertUser(@RequestBody User newUser) {
		return userservice.insertUser(newUser);

	}
 
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {

		return userservice.updateUser(user);
	}

	// to get all the data from the database
	@GetMapping("/getAllUserList")
	public List<User> getUsers() {
		return userservice.getUsers();
	}

	// get by id
	@GetMapping("/GetByUserId/{userId}")
	public User find(@PathVariable("userId") int userId) {
		return userservice.userfind(userId);
	}

	@GetMapping("/loginUser/{userName}/{userPassword}")
	public User loginUser(@PathVariable("userName") String userName,
			@PathVariable("userPassword") String userPassword) {

		return userservice.userLogin(userName, userPassword);

	}
	

	@GetMapping("/getAllUsersById")
	public List<User> getAllUserListById(int userId) {
		return userservice.getAllUsersById(userId);
	}
}
