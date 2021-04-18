package com.neuedu.elm_servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.Orders;
import com.neuedu.elm_servlet.service.OrdersService;
import com.neuedu.elm_servlet.service.impl.OrdersServiceImpl;

public class OrdersController {
	private OrdersService ordersService = new OrdersServiceImpl();
	
	public int createOrders(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String daId = request.getParameter("daId");
		String orderTotal = request.getParameter("orderTotal");
		
		 Orders orders = new Orders();
		 orders.setBusinessId(Integer.valueOf(businessId));
		 orders.setUserId(userId);
		 orders.setDaId(Integer.valueOf(daId));
		 orders.setOrderTotal(Double.valueOf(orderTotal));
		 int count = ordersService.createOrders(orders);
		 
		return count;
	}
	/*/
	 * 在线支付初始化
	 */
	public Orders getOrdersById(HttpServletRequest request) {
		String orderSn = request.getParameter("orderSn");
		Orders orders = ordersService.getOrdersById(orderSn);
		return orders;
	}
	/*/
	 * 历史订单页初始化
	 */
	public List<Orders> listOrdersByUserId(HttpServletRequest request){
		String userId = request.getParameter("userId");
		List<Orders> list = ordersService.listOrdersByUserId(userId);
		
		return list;
	}
}
