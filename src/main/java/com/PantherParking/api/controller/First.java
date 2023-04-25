package com.PantherParking.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pantherparking/first")
public class First {
	
	@GetMapping("/sample")
	public String sample(){
		return "hello world";
	}
}
