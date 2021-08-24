package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Controller
public class ApplicationController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/index")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<Role> roleList = roleRepository.findAll();
		model.addAttribute("roleList", roleList);
		
		return "register";
	}
	
	@GetMapping("/register1")
	public String register1(Model model) {
		List<Role> roleList = roleRepository.findAll();
		model.addAttribute("roleList", roleList);
		
		return "registerAdmin";
	}

}
