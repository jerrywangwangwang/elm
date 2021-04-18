package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.elm_servlet.dao.FoodDao;
import com.neuedu.elm_servlet.dao.impl.FoodDaoImpl;
import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.service.FoodService;
import com.neuedu.elm_servlet.util.DBUtil;

public class FoodServiceImpl implements FoodService {
		FoodDao foodDao = new FoodDaoImpl();
	@Override
	public List<Food> listFoodByBusinessId(String businessId) {
		
		Connection con = DBUtil.getConnection();
		List<Food> foodList = null;
		try {
			foodList = foodDao.listFoodByBusinessId(businessId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return foodList;
	}

}
