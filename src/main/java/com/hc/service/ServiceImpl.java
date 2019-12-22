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
		System.out.println("from service");
		int checkemailExist = dao.findByEmail(user.getEmail());

		if (checkemailExist == 1) {
			return "200";
		} else {
			return "404";
		}

	}

	@Override
	public String adduser(UserModel user) {
		UserModel adduserstatus = dao.save(user);
		return null;
	}

	@Override
	public String saveUser(UserModel user) {

		System.out.println("from service method");
		UserModel str = dao.save(user);
		System.out.println("aftersave quesry: " + str);

		return null;
	}

}
