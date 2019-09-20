package com.snake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snake.dao.UserObj;
import com.snake.mapper.UserMapper;
import com.snake.model.User;
import com.snake.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public boolean login(User user) {
		UserObj userObj = userMapper.selectUserByName(user.getName());
		if (userObj == null) {
			return false;
		}
		
		if (user.getPassword().equals(userObj.getPassword())) {
			return true;
		}
		
		return false;
	}

}
