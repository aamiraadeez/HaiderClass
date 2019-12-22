package com.hc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hc.model.UserModel;

@Repository
public class DaoImpl {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public String getEmail(String email) {
//		System.out.println("from Dao impl");
//		return jdbcTemplate.queryForObject("select count(*) from hcuser where email=?", String.class, email);
//	}
//
//	@Override
//	public int addUser(UserModel user) {
////		System.out.println("from adduser: daoimpl ");
////		String sql = "INSERT INTO m3 (role ,firstName, lastName, email, password ,confirmPassword, gender, address, phoneNumber, maritalStatus , salary ,datePicker , imgUrl) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
////		return jdbcTemplate.update(sql, user.getRole(), user.getFirstName(), user.getLastName(), user.getEmail(),
////				user.getPassword(), user.getConfirmPassword(), user.getGender(), user.getAddress(),
////				user.getPhoneNumber(), user.getMaritalStatus(), user.getSalary(), user.getDatePicker(),
////				user.getImgUrl());
//		return 1;

//	}
}
