package com.neuedu.elm_servlet.service;

import com.neuedu.elm_servlet.entity.User;

public interface LoginService {

	User getUserByIdByPass(String username, String password);

	int getUserById(String userid);

	int saveUser(User user);

}
