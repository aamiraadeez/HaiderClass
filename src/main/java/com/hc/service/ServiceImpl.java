package com.hc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.dao.DaoIface;
import com.hc.model.UserModel;

@Service
public class ServiceImpl implements ServiceIface {
	@Autowired
	DaoIface dao;

	@Override
	public String validateUser(UserModel user) {

		int checkemailExist = dao.findByEmail(user.getEmail());
		if (checkemailExist == 1) {
			int checkpasswordExist = dao.verifyUserByPassword(user.getEmail(), user.getPassword());
			if (checkpasswordExist == 1) {
				return "200";
			} else {
				return "400";
			}
		} else {
			return "404";
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
