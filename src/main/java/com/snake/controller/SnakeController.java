package com.snake.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SnakeController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("mapping index");
		return "index";
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
}
