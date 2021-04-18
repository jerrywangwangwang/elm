package com.neuedu.elm_servlet.dao;

import com.neuedu.elm_servlet.entity.User;

public interface LoginDao {

	User getUserByIdByPass(String username, String password) throws Exception;

	int getUserById(String userid) throws Exception;

	int saveUser(User user) throws Exception;

}
