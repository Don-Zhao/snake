package com.snake.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;

import redis.clients.jedis.JedisShardInfo;


@Configuration
@MapperScan("com.snake.mapper")
@EnableCaching
//@ComponentScan(basePackages= {"com.snake.properties"})
//@EnableTransactionManagement
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
		
		return dataSource;
	}
	
	@Bean
	@Qualifier
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
	
//	@Bean
//	public CacheManager cacheManager() {
//		SimpleCacheManager manager = new SimpleCacheManager();
//		return manager;
//	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisShardInfo info = new JedisShardInfo("localhost");
		JedisConnectionFactory factory = new JedisConnectionFactory(info);
		return factory;
	}
	
	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager manager = RedisCacheManager.create(redisConnectionFactory());
		return manager;
	}
	
//	@Bean
//	public DataSourceTransactionManager transactionManager() throws SQLException {
//		DataSourceTransactionManager manager = new DataSourceTransactionManager();
//		manager.setDataSource(dataSource());
//		
//		return manager;
//	}
}
