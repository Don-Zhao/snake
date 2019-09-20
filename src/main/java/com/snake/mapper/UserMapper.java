package com.snake.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

import com.snake.dao.UserObj;

@Mapper
@Qualifier("userMapper")
public interface UserMapper {
	
	@Select("SELECT * FROM user WHERE name=#{name}")
	public UserObj selectUserByName(String name);
}
