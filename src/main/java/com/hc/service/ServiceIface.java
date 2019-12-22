package com.hc.service;

import com.hc.model.UserModel;

public interface ServiceIface {

	String validateUser(UserModel user);

	String saveUser(UserModel user);

}
