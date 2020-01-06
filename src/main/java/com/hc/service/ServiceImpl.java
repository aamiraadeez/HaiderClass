package com.hc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hc.dao.DaoIface;
import com.hc.model.UserModel;

@Service
public class ServiceImpl implements ServiceIface {
	@Autowired
	DaoIface dao;

	@Override
	public ResponseEntity<UserModel> validateUser(UserModel user) {
		UserModel usermodel = new UserModel();
		int checkemailExist = dao.findByEmail(user.getEmail());
		if (checkemailExist == 1) {
			int checkpasswordExist = dao.verifyUserByPassword(user.getEmail(), user.getPassword());
			if (checkpasswordExist == 1) {
				usermodel.setStatus("Succesfully login...");
				return ResponseEntity.ok(usermodel);
			} else {
				usermodel.setStatus("Incorrect password");
				return ResponseEntity.badRequest().body(usermodel);
			}
		} else {
			usermodel.setStatus("Email and password does not exist");
			return ResponseEntity.badRequest().body(usermodel);
		}
	}

	@Override
	public String saveUser(UserModel user) {
		System.out.println("from service method");
		UserModel saveStatus = dao.save(user);
		if (saveStatus != null) {
			return "200";
		} else {
			return "202";
		}
	}
}
