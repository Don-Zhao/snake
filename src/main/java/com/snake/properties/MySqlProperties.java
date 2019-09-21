package com.snake.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@PropertySource("classpath:db.propertis")
public class MySqlProperties {
	
	@Value("${com.snake.db.url}")
	private String url;
	
	@Value("${com.snake.db.driver}")
	private String driver;
	
	@Value("${com.snake.db.username}")
	private String username;
	
	@Value("${com.snake.db.password}")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
