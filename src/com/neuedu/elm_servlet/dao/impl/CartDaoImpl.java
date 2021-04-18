package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.elm_servlet.dao.CartDao;
import com.neuedu.elm_servlet.entity.Business;
import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.util.DBUtil;
import com.neuedu.elm_servlet.util.StringUtil;

public class CartDaoImpl implements CartDao  {

	@Override
	public int saveCart(Cart cart) throws Exception {
		Connection con = DBUtil.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into cart values(null,?,?,?,1)");
		ps.setInt(1, cart.getFoodId());
		ps.setInt(2, cart.getBusinessId());
		ps.setString(3, cart.getUserId());
		int count = ps.executeUpdate();
		DBUtil.close(con);
		return count;
	}

	@Override
	public int updateCart(Cart cart) throws Exception {
Connection con = DBUtil.getConnection();
		
		PreparedStatement ps = con.prepareStatement("update  cart set quantity=? where userId=? and businessId=? and foodId=? ");
		ps.setInt(1, cart.getQuantity());
		ps.setInt(3, cart.getBusinessId());
		ps.setString(2, cart.getUserId());
		ps.setInt(4, cart.getFoodId());
		int count = ps.executeUpdate();
		DBUtil.close(con);
		
		return count;
	}

	@Override
	public int removeCart(Cart cart) throws Exception {
		Connection con = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("delete from  cart where userId=? and businessId=? ");
		if(StringUtil.isNotEmpty(cart.getFoodId())) {
			sql.append(" and foodId=?");
		}
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setString(1, cart.getUserId());
		ps.setInt(2, cart.getBusinessId());
		if(StringUtil.isNotEmpty(cart.getFoodId())) {
			ps.setInt(3, cart.getFoodId());
		}
		int count = ps.executeUpdate();
		DBUtil.close(con);
		
		return count;
	}

	@Override
	public List<Cart> listCart(Cart cart) throws Exception {
		Connection con = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select c.quantity"
				+ ",f.foodId"
				+ ",f.foodName"
				+ ",f.foodPrice"
				+ ",f.foodImg"
				+ ",foodExplain"
				+ ",b.businessId"
				+ ",b.businessName"
				+ ",b.businessAddress"
				+ ",b.businessExplain"
				+ ",b.starPrice"
				+ ",b.deliveryPrice from cart c left join food f on c.foodId=f.foodId left join business b on c.businessId=b.businessId where c.userId=? ");
		if(StringUtil.isNotEmpty(cart.getBusinessId())) {
			sql.append(" and c.businessId=?");
		}
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setString(1, cart.getUserId());
		if(StringUtil.isNotEmpty(cart.getBusinessId())) {
			ps.setInt(2, cart.getBusinessId());
		}
		ResultSet rs = ps.executeQuery();
	
		ArrayList<Cart> list = new ArrayList<>();
		
		while(rs.next()) {
			cart = new Cart();
			Food food = new Food();
			Business business = new Business();
			cart.setBusinessId(rs.getInt("businessId"));
			cart.setFoodId(rs.getInt("foodId"));
			cart.setQuantity(rs.getInt("quantity"));
			food.setFoodId(rs.getInt("foodId"));
			food.setFoodName(rs.getString("foodName"));
			food.setFoodImg(rs.getString("foodImg"));
			food.setFoodExplain(rs.getString("foodExplain"));
			food.setFoodPrice(rs.getDouble("foodPrice"));
			business.setBusinessId(rs.getInt("businessId"));
			business.setBusinessName(rs.getString("businessName"));
			business.setBusinessAddress(rs.getString("businessAddress"));
			business.setBusinessExplain(rs.getString("businessExplain"));
			business.setStarPrice(rs.getDouble("starPrice"));
			business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			cart.setFood(food);
			cart.setBusiness(business);
			list.add(cart);
		}
		DBUtil.close(rs, ps);
		return list;
	}



}
