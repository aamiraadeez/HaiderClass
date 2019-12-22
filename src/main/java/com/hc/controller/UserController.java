package com.hc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hc.model.UserModel;
import com.hc.service.ServiceIface;

@RestController
@RequestMapping("/agents")
public class UserController {

	@Autowired
	ServiceIface service;

	@GetMapping(value = "/login")
	public String login() {
		System.out.println("from login ");
		return "login";
	}

	@PostMapping(value = "/UserValidation")
	public String UserValidations(@RequestBody UserModel user) {
		System.out.println("from UserValidations: " + user);
		String uservalidationsstatus = service.validateUser(user);
		if (uservalidationsstatus.equals("200")) {
			return "dashboard";
		} else {
			return "login";
		}
	}

	@GetMapping(value = "/newRegistertation")
	public String hello() {
		System.out.println("from hello ");
		return "newRegistertation";
	}

	@PostMapping(value = "/addUser")
	public String addUser(UserModel user) {

		String adduserstatus = service.adduser(user);

		return "login";
	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserModel user) {
		System.out.println("from contrller of save user: " + user);

		String savestatus = service.saveUser(user);

		return null;

	}

}
