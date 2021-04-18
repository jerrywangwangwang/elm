package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.elm_servlet.dao.CartDao;
import com.neuedu.elm_servlet.dao.FoodDao;
import com.neuedu.elm_servlet.dao.OrdersDao;
import com.neuedu.elm_servlet.dao.impl.CartDaoImpl;
import com.neuedu.elm_servlet.dao.impl.FoodDaoImpl;
import com.neuedu.elm_servlet.dao.impl.OrdersDaoImpl;
import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.entity.OrderDetailet;
import com.neuedu.elm_servlet.entity.Orders;
import com.neuedu.elm_servlet.service.OrdersService;
import com.neuedu.elm_servlet.util.DBUtil;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao = new OrdersDaoImpl();
	private CartDao cartDao = new CartDaoImpl();
	@Override
	public int createOrders(Orders orders) {
		Connection con = DBUtil.getConnection();
		System.out.println("1"+con);
		int orderSn=-1;
		try {
			DBUtil.beginTransaction();
			//鏍规嵁鐢ㄦ埛id鍜屽晢瀹秈d浠庤喘鐗╄溅琛ㄤ腑鏌ヨ鍑嗗鏂板鐨勯鍝佷俊鎭�
			Cart cart = new Cart();
			cart.setBusinessId(orders.getBusinessId());
			cart.setUserId(orders.getUserId());
			 List<Cart> list = cartDao.listCart(cart);
			//鏂板璁㈠崟琛紝骞舵嬁鍒拌繑鍥炵殑璁㈠崟id
			orderSn= ordersDao.createOrders(orders);
			//鎵归噺鏂板璁㈠崟鏄庣粏琛ㄦ暟鎹�
			int count= ordersDao.createOrdersDetail(list,orderSn);
			//娓呯┖瀵瑰簲鍟嗗锛屽搴旂敤鎴蜂笅鐨勮喘鐗╄溅鏁版嵁
			int count1 =cartDao.removeCart(cart);
			DBUtil.commitTransaction();
			
		} catch (Exception e) {
			orderSn=-1;
			System.out.println("鍒涘缓璁㈠崟涓氬姟寮傚父");
			e.printStackTrace();
			DBUtil.rollbackTransaction();
		}finally {
			DBUtil.close(con);
		}
		return orderSn;
	}
	@Override
	public Orders getOrdersById(String count) {
		Connection con = DBUtil.getConnection();
		Orders orders =null;
		try {
			orders = ordersDao.getOrdersById(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return orders;
	}
	@Override
	public List<Orders> listOrdersByUserId(String userId) {
		Connection con = DBUtil.getConnection();
		List<Orders> list =null;
		try {
			list = ordersDao.listOrdersByUserId(userId);
			
			list.forEach(item->{
				List<OrderDetailet> listdetail =null;
				try {
					listdetail = ordersDao.listOrdersDetailByOrderId(item.getOrderId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setList(listdetail);
			});
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		
		return list;
	}
	
}
