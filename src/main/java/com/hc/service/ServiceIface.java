package com.hc.service;

import com.hc.model.UserModel;

public interface ServiceIface {

	String validateUser(UserModel user);

	String adduser(UserModel user);

	String saveUser(UserModel user);

}
