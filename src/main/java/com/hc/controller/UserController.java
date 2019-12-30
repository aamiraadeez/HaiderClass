package com.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hc.model.UserModel;
import com.hc.service.ServiceIface;

@RestController
@RequestMapping("/agents")
public class UserController {
	@Autowired
	ServiceIface service;

	@GetMapping("/login")
	public ModelAndView forget() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@PostMapping(value = "/UserValidation")
	public String UserValidations(@RequestBody UserModel user) {
		String uservalidationsstatus = service.validateUser(user);
		if (uservalidationsstatus.equals("200")) {
			return "Succesfully login...";
		} else if (uservalidationsstatus.equals("400")) {
			return "Incorrect password";
		} else if (uservalidationsstatus.equals("404")) {
			return "Email and password does not exist";
		} else {
			return "";
		}

	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserModel user) {
		String saveStatus = service.saveUser(user);
		if (saveStatus.equals("200")) {
			return "200";
		} else if (saveStatus.equals("202")) {
			return "202";
		} else {
			return "202";
		}
	}
}
