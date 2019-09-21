package com.snake.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;


@Configuration
@MapperScan("com.snake.mapper")
//@ComponentScan(basePackages= {"com.snake.properties"})
public class SnakeRootConfig {
	
//	@Autowired
//	private MySqlProperties properties;
	
	@Bean
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/snake");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
//		dataSource.setDriverClassName(properties.getDriver());
//		dataSource.setUrl(properties.getUrl());
//		dataSource.setUsername(properties.getUsername());
//		dataSource.setPassword(properties.getPassword());
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws SQLException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		return bean;
	}
	
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer configurger = new MapperScannerConfigurer();
//		configurger.setBasePackage("com.snake.mapper");
//		
//		return configurger;
//	}
}
