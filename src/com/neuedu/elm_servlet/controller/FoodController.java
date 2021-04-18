package com.neuedu.elm_servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.Food;
import com.neuedu.elm_servlet.service.FoodService;
import com.neuedu.elm_servlet.service.impl.FoodServiceImpl;

public class FoodController {
	
	private FoodService foodService = new FoodServiceImpl();
	
	/**
	 * 返回对应商家的食品列表
	 */
	public List<Food> listFoodByBusinessId(HttpServletRequest request){
		
		String businessId = request.getParameter("businessId");
		
		List<Food> foodList = foodService.listFoodByBusinessId(businessId);
		
		return foodList;
	}
	

}
