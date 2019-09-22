package com.snake.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.beans.factory.annotation.Qualifier;

import com.snake.dao.UserObj;

@Mapper
@Qualifier("userMapper")
@CacheNamespace(implementation=RedisCache.class,blocking=true)
public interface UserMapper {
	
	@Select("SELECT * FROM user WHERE name=#{name}")
	public UserObj selectUserByName(String name);
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	public UserObj selectUserById(int id);
}
