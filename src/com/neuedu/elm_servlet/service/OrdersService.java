package com.neuedu.elm_servlet.service;

import java.util.List;

import com.neuedu.elm_servlet.entity.Orders;

public interface OrdersService {

	int createOrders(Orders orders);

	Orders getOrdersById(String count);

	List<Orders> listOrdersByUserId(String userId);

	

}
