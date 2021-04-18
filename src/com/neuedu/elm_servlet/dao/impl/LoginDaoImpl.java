package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.neuedu.elm_servlet.dao.LoginDao;
import com.neuedu.elm_servlet.entity.User;
import com.neuedu.elm_servlet.util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User getUserByIdByPass(String username, String password) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select userId,userName,userSex from user where userId=? and password =? ");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		User user = new User();
		while (rs.next()) {
			user.setUserId(rs.getString("userId"));
			user.setUserName(rs.getString("userName"));
			user.setUserSex(rs.getInt("userSex"));
			
		}
		DBUtil.close(rs, ps);
		return user;
	}

	@Override
	public int getUserById(String userid) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select count(1) from user where userId=?");
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		
		int count = 0;
		while (rs.next()) {
			count=rs.getInt("count(1)");
			
		}
		DBUtil.close(rs, ps);
		return count;
	}

	@Override
	public int saveUser(User user) throws Exception {
		Connection con = DBUtil.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,'',1)");
		ps.setString(1, user.getUserId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getUserName());
		ps.setInt(4, user.getUserSex());
		int count = ps.executeUpdate();
		DBUtil.close(con);
		return count;
	}
	
}
