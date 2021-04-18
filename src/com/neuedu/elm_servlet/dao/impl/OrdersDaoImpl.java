package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.elm_servlet.dao.OrdersDao;
import com.neuedu.elm_servlet.entity.Business;
import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.entity.OrderDetailet;
import com.neuedu.elm_servlet.entity.Orders;
import com.neuedu.elm_servlet.util.DBUtil;
import com.neuedu.elm_servlet.util.DateUtil;

public class OrdersDaoImpl implements OrdersDao  {

	@Override
	public int createOrders(Orders orders) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into orders values(null,?,?,?,?,?,0)",PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, orders.getUserId());
		ps.setInt(2, orders.getBusinessId());
		ps.setString(3, DateUtil.getCurrentDate());
		ps.setDouble(4, orders.getOrderTotal());
		ps.setInt(5, orders.getDaId());
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int key =-1;
		while(rs.next()) {
		 key=rs.getInt(1);
		}
		DBUtil.close(rs, ps);
		
		return key;
	}

	@Override
	public int createOrdersDetail(List<Cart> list, int orderSn) throws Exception {
		Connection con = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("insert into orderdetailet values");
		
		for(Cart item:list) {
			sql.append("(null,"+orderSn+","+item.getFoodId()+","+item.getQuantity()+"),");
		}
	    PreparedStatement ps = con.prepareStatement(sql.toString().substring(0,sql.length()-1));
		
		int count = ps.executeUpdate();
		
		DBUtil.close( ps);
		return count;

	}

	@Override
	public Orders getOrdersById(String count) throws Exception {
		Connection con = DBUtil.getConnection();
		Orders orders = new Orders();
		Business business = new Business();
		List<OrderDetailet> list= new ArrayList<>();
		con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT o.orderTotal,b.businessName,b.deliveryPrice,f.foodName,od.quantity,f.foodPrice "
				+ "FROM orders o  LEFT JOIN business b on o.businessId=b.businessId "
				+ "LEFT JOIN orderdetailet od on o.orderId=od.orderId  "
				+ "LEFT JOIN food f ON od.foodId = f.foodId  "
				+ "WHERE o.orderid = ?");	
		ps.setString(1, count);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()){
	    	OrderDetailet od = new OrderDetailet();
	    	Food food = new Food();
	    	orders.setOrderTotal(rs.getDouble("orderTotal"));
	    	food.setFoodName(rs.getString("foodName"));
	    	food.setFoodPrice(rs.getDouble("foodPrice"));
	   
	    	od.setFood(food);
	    	od.setQuantity(rs.getInt("quantity"));
	    	business.setBusinessName(rs.getString("businessName"));
	    	list.add(od);
	    }
	    orders.setList(list);
	    orders.setBusiness(business);
	    
	    DBUtil.close(rs, ps);
		return orders;
	}

	@Override
	public List<Orders> listOrdersByUserId(String userId) throws Exception {
		Connection con = DBUtil.getConnection();
		
		
		List<Orders> list= new ArrayList<>();
		con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT o.orderState,o.orderId,o.orderTotal,b.businessName,b.deliveryPrice,"
				+ "FROM orders o  LEFT JOIN business b on o.businessId=b.businessId "
				+ "WHERE o.userid = ?");	
		ps.setString(1, userId);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()){
	    	Orders orders = new Orders();
	    	Business business = new Business();
	    	orders.setOrderState(rs.getInt("orderState"));
	    	orders.setOrderTotal(rs.getDouble("orderTotal"));
	    	orders.setOrderId(rs.getInt("orderId"));
	    	business.setBusinessName(rs.getString("businessName"));
	    	business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
	    	orders.setBusiness(business);
	    	list.add(orders);
	    }
	    DBUtil.close(rs, ps);
		return list;
	}

	@Override
	public List<OrderDetailet> listOrdersDetailByOrderId(Integer orderId)throws Exception {
		List<OrderDetailet> list= new ArrayList<>();
		Connection con = DBUtil.getConnection();
		 PreparedStatement ps = con.prepareStatement("SELECT f.foodName,od.quantity,f.foodPrice "
				+ "FROM "
				+ "orderdetailet od "
				+ "LEFT JOIN food f ON od.foodId = f.foodId  "
				+ "WHERE od.orderid = ?");	
		ps.setInt(1, orderId);
	     ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()){
	    	OrderDetailet od = new OrderDetailet();
	    	Food food = new Food();
	    	food.setFoodName(rs.getString("foodName"));
	    	food.setFoodPrice(rs.getDouble("foodPrice"));
	    	od.setFood(food);
	    	od.setQuantity(rs.getInt("quantity"));
	    	list.add(od);
	    }
	    
	    DBUtil.close(rs, ps);
		return list;
	}
}
