package com.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.hc.dao.DaoIface;
import com.hc.model.UserModel;
import com.hc.service.ServiceIface;

@RestController
@RequestMapping("/agents")
public class UserController {
	@Autowired
	ServiceIface service;

	@Autowired
	DaoIface dao;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@GetMapping("/dashboard")
	public ModelAndView calldashboard() {
		ModelAndView mav = new ModelAndView("dashboard");
		return mav;
	}

	@GetMapping("/signup")
	public ModelAndView sign() {
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}

	@PostMapping(value = "/UserValidation")
	public ResponseEntity<?> UserValidations(@RequestBody UserModel user) {
		ResponseEntity<UserModel> uservalidationsstatus = service.validateUser(user);
		HttpStatus httpcode = uservalidationsstatus.getStatusCode();
		if (httpcode == HttpStatus.OK) {
			return ResponseEntity.ok(uservalidationsstatus);
		} else {
			return ResponseEntity.badRequest().body(uservalidationsstatus);
		}
	}
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody UserModel user) {
		System.out.println("from save User: ");
		String saveStatus = service.saveUser(user);
		if (saveStatus.equals("200")) {
			return "200";
		} else if (saveStatus.equals("202")) {
			return "202";
		} else {
			return "202";
		}
	}

	@PutMapping("/editUser")
	public ResponseEntity<UserModel> editUser(@RequestBody UserModel user) throws Exception {
		UserModel usermodel = dao.findById(user.getUserId())
				.orElseThrow(() -> new Exception("User not found on :: " + user.getUserId()));
		usermodel.setEmail(user.getEmail());
		usermodel.setName(user.getName());
		usermodel.setPhone(user.getPhone());
		final UserModel updatedUser = dao.save(usermodel);
		return ResponseEntity.ok(updatedUser);
	}
}
