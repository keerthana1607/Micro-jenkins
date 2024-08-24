package com.keerthana.demo.serviceimpl;

import com.keerthana.demo.service.UserService;

import com.keerthana.demo.model.User;
import com.keerthana.demo.repo.UserRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userdao;

	@Override
	public User insertUser(User newUser) {
		return userdao.insertUser(newUser);

	}

	@Override
	public User updateUser(User user) {
		return userdao.updateUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userdao.getUsers();
	}

	@Override
	public User userfind(int userId) {
		return userdao.userfind(userId);
	}

	@Override
	public List<Integer> getUserIdlist() {
		return userdao.getUserIdlist();
	}

	@Override
	public List<User> searchUser(String userName) {
		return userdao.searchUser(userName);
	}

	@Override
	public User userLogin(String userName, String userPassword) {
		return userdao.userLogin(userName, userPassword);
	}

	@Override
	public List<User> getAllUsersById(int userId) {
		return userdao.getUsersIdlist(userId);
	}
}
