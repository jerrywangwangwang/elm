package com.neuedu.elm_servlet.dao;

import java.util.List;

import com.neuedu.elm_servlet.entity.Cart;
import com.neuedu.elm_servlet.entity.OrderDetailet;
import com.neuedu.elm_servlet.entity.Orders;

public interface OrdersDao {

	int createOrders(Orders orders) throws Exception;

	int createOrdersDetail(List<Cart> list, int orderSn) throws Exception;

	Orders getOrdersById(String count) throws Exception;

	List<Orders> listOrdersByUserId(String userId) throws Exception;

	List<OrderDetailet> listOrdersDetailByOrderId(Integer orderId) throws Exception;

	

	

}
