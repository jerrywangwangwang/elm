package com.neuedu.elm_servlet.service;

import java.util.List;

import com.neuedu.elm_servlet.entity.Food;

public interface FoodService {

	List<Food> listFoodByBusinessId(String businessId);

}
