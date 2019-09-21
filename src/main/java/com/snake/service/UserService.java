package com.snake.service;

import com.snake.model.User;

public interface UserService {
	public boolean login(User user);
	
	public boolean exist(int id);
}
