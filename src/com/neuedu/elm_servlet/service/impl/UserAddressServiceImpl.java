package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.elm_servlet.dao.CartDao;
import com.neuedu.elm_servlet.dao.LoginDao;
import com.neuedu.elm_servlet.dao.UserAddressDao;
import com.neuedu.elm_servlet.dao.impl.CartDaoImpl;
import com.neuedu.elm_servlet.dao.impl.LoginDaoImpl;
import com.neuedu.elm_servlet.dao.impl.UserAddressDaoImpl;
import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.entity.DeliveryAddress;
import com.neuedu.elm_servlet.service.UserAddressService;
import com.neuedu.elm_servlet.util.DBUtil;

public class UserAddressServiceImpl implements UserAddressService {
	private UserAddressDao userAddressDao = new UserAddressDaoImpl();
	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		Connection con = DBUtil.getConnection();
		List<DeliveryAddress> list = null;
		try {
			 list = userAddressDao.listDeliveryAddressByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return list;
	}
	@Override
	public int saveDeliveryAddress(DeliveryAddress da) {
		
		int count =0;
		Connection con =null;
		try {
			con = DBUtil.getConnection();
			count = userAddressDao.saveDeliveryAddress(da);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return count;
	}
	@Override
	public DeliveryAddress getDeliveryAddressById(String daId) {
		Connection con = DBUtil.getConnection();
		 
		
		
		return null;
	}

}
