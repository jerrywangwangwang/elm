package com.neuedu.elm_servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.service.CartService;
import com.neuedu.elm_servlet.service.impl.CartServiceImpl;
import com.neuedu.elm_servlet.util.StringUtil;

public class CartController {
	/**
	 * 查询购物车
	 */
	public List<Cart> listCart(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		Cart cart = new Cart();
		cart.setUserId(userId);
		if (StringUtil.isNotEmpty(businessId)) {
			cart.setBusinessId(Integer.valueOf(businessId));
		}
		List<Cart> list = cartService.listCart(cart);
		return list;
	}

	private CartService cartService = new CartServiceImpl();

	public int saveCart(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String foodId = request.getParameter("foodId");
		Cart cart = new Cart();

		cart.setBusinessId(Integer.valueOf(businessId));
		cart.setFoodId(Integer.valueOf(foodId));
		cart.setUserId(userId);

		int count = cartService.saveCart(cart);
		return count;
	}

	public int updateCart(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String foodId = request.getParameter("foodId");
		String qt = request.getParameter("quantity");
		Cart cart = new Cart();

		cart.setBusinessId(Integer.valueOf(businessId));
		cart.setFoodId(Integer.valueOf(foodId));
		cart.setUserId(userId);
		cart.setQuantity(Integer.valueOf(qt));

		int count = cartService.updateCart(cart);
		return count;
	}

	/*
	 * / 删除购物车
	 */
	public int removeCart(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String foodId = request.getParameter("foodId");
		Cart cart = new Cart();
		if (StringUtil.isNotEmpty(foodId)) {
			cart.setFoodId(Integer.valueOf(foodId));
		}
		cart.setBusinessId(Integer.valueOf(businessId));
		cart.setUserId(userId);
		int count = cartService.removeCart(cart);
		return count;

	}
}
