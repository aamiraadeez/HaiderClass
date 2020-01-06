package com.hc.service;

import org.springframework.http.ResponseEntity;
import com.hc.model.UserModel;

public interface ServiceIface {
	String saveUser(UserModel user);

	ResponseEntity<UserModel> validateUser(UserModel user);

}
