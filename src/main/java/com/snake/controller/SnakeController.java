package com.snake.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.snake.model.User;
import com.snake.service.UserService;

@Controller
public class SnakeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("mapping index");
		return "login";
	}
	
	@RequestMapping("/path")
	public String path() {
		userService.exist(4);
		return "path";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,
						 @RequestParam("userFile") MultipartFile part) {
		try {
			String fileName = part.getOriginalFilename();
			System.out.println(fileName);
			part.transferTo(new File("D://tmp//" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "path";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload() {
		return "upload";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String name, @RequestParam String password, WebRequest webRequest) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		boolean isLogin = userService.login(user);
		if (isLogin) {
			webRequest.setAttribute("isLogin", true, RequestAttributes.SCOPE_SESSION);
			webRequest.setAttribute("username", user.getName(), RequestAttributes.SCOPE_SESSION);
			return "home";
		}
		
		return "login";
	}
}

