package com.neuedu.elm_servlet.dao;

import java.util.List;

import com.neuedu.elm_servlet.entity.Food;

public interface FoodDao  {

	List<Food> listFoodByBusinessId(String businessId)throws Exception;

}
