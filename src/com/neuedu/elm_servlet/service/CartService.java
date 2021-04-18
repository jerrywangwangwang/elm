package com.neuedu.elm_servlet.service;

import java.util.List;

import com.neuedu.elm_servlet.entity.Cart;

public interface CartService {

	int saveCart(Cart cart);

	int updateCart(Cart cart);

	int removeCart(Cart cart);

	List<Cart> listCart(Cart cart);

}
