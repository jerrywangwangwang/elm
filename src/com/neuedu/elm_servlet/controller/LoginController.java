package com.neuedu.elm_servlet.controller;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.User;
import com.neuedu.elm_servlet.service.LoginService;
import com.neuedu.elm_servlet.service.impl.LoginServiceImpl;

public class LoginController {
	private LoginService loginService = new LoginServiceImpl();
	
	public User getUserByIdByPass(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = loginService.getUserByIdByPass(username,password);
		
		
		return user;
		
	}
	/*/
	 * 获取用户数量
	 */
	public int getUserById(HttpServletRequest request) {
		String userid = request.getParameter("userid");
		int count = loginService.getUserById(userid);
		return count;
	}
	
	/*/
	 * 注册
	 */
	public int saveUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userid = request.getParameter("userid");
		String usersex = request.getParameter("usersex");
		User user = new User();
		user.setUserId(userid);
		user.setPassword(password);
		user.setUserName(username);
		user.setUserSex(Integer.valueOf(usersex));
		
		int count = loginService.saveUser(user);
		return count;
	}
}
