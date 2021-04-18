package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.elm_servlet.dao.CartDao;
import com.neuedu.elm_servlet.dao.impl.CartDaoImpl;
import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.service.CartService;
import com.neuedu.elm_servlet.util.DBUtil;

public class CartServiceImpl implements CartService {
	
	@Override
	public int saveCart(Cart cart) {
		CartDao cartDao = new  CartDaoImpl();
		Connection con = DBUtil.getConnection();
		int count = 0;
		try {
			count = cartDao.saveCart(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
	return count;
}

	@Override
	public int updateCart(Cart cart) {
		CartDao cartDao = new  CartDaoImpl();
		Connection con = DBUtil.getConnection();
		int count = 0;
		try {
			count = cartDao.updateCart(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return count;
	}

	@Override
	public int removeCart(Cart cart) {
		CartDao cartDao = new  CartDaoImpl();
		Connection con = DBUtil.getConnection();
		int count = 0;
		try {
			count = cartDao.removeCart(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return count;
	}

	

	@Override
	public List<Cart> listCart(Cart cart) {
		CartDao cartDao = new  CartDaoImpl();
		Connection con = DBUtil.getConnection();
		List<Cart> list = null;
		try {
			 list = cartDao.listCart(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return list;
	}


}
