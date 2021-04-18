package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.elm_servlet.dao.FoodDao;
import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.util.DBUtil;

public class FoodDaoImpl implements FoodDao{

	@Override
	public List<Food> listFoodByBusinessId(String businessId) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pre =null;
		ResultSet rs =null;
		
			pre = con.prepareStatement("select foodId,foodName,foodExplain,foodImg,foodPrice,remarks from food where"
					+ " businessId=?");
			pre.setString(1, businessId);
			rs = pre.executeQuery();
			ArrayList<Food> arrayList = new ArrayList<>();
			while(rs.next()) {
				Food food = new Food();
				//food.setBusinessId(rs.getInt("businessId"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodImg(rs.getString("foodImg"));
				food.setFoodName(rs.getString("foodName"));
				food.setRemarks(rs.getString("remarks"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				arrayList.add(food);
			}
		
			DBUtil.close(rs, pre);
		return arrayList;
	}

}
