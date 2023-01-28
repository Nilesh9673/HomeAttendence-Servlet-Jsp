package com.jsp.service;

import java.util.List;
import com.jsp.dao.UserDao;
import com.jsp.dto.UserDto;

public class UserService {
	UserDao userDao = new UserDao();

	// save User
	public UserDto saveUser(UserDto user) {
		return userDao.saveUser(user);
	}

	// get by id
	public UserDto getById(int id) {
		return userDao.getById(id);
	}

	// get all
	public List<UserDto> getAllUser() {
		return userDao.getAllUser();
	}

	// verify user
	public boolean verify(String username, String password) {
		return userDao.verify(username, password);
	}

	public int userId(String userName, String passWord) {
		return userDao.userId(userName, passWord);
	}

}
