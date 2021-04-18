package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;

import com.neuedu.elm_servlet.dao.LoginDao;
import com.neuedu.elm_servlet.dao.impl.LoginDaoImpl;
import com.neuedu.elm_servlet.entity.User;
import com.neuedu.elm_servlet.service.LoginService;
import com.neuedu.elm_servlet.util.DBUtil;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();
	@Override
	public User getUserByIdByPass(String username, String password) {
		User user =null;
		Connection con =null;
		try {
			con = DBUtil.getConnection();
			user = loginDao.getUserByIdByPass(username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return user;
	}
	@Override
	public int getUserById(String userid) {
		LoginDao loginDao = new LoginDaoImpl();
			int count =0;
			Connection con =null;
			try {
				con = DBUtil.getConnection();
				count = loginDao.getUserById(userid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.close(con);
			}
			return count;
	}
	@Override
	public int saveUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		int count =0;
		Connection con =null;
		try {
			con = DBUtil.getConnection();
			count = loginDao.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return count;
	}

}
