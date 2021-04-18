package com.neuedu.elm_servlet.dao;

import java.util.List;

import com.neuedu.elm_servlet.entity.Cart;

public interface CartDao {

	int saveCart(Cart cart) throws Exception;

	int updateCart(Cart cart) throws Exception;

	int removeCart(Cart cart) throws Exception;

	List<Cart> listCart(Cart cart) throws Exception;;
}
