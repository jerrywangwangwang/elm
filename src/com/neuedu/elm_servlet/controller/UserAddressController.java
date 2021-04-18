package com.neuedu.elm_servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.DeliveryAddress;
import com.neuedu.elm_servlet.service.UserAddressService;
import com.neuedu.elm_servlet.service.impl.UserAddressServiceImpl;

public class UserAddressController {
	private UserAddressService userAddressService = new UserAddressServiceImpl();
	
	public List<DeliveryAddress> listDeliveryAddressByUserId(HttpServletRequest request){
		String userId = request.getParameter("userId");
		List<DeliveryAddress> list = userAddressService.listDeliveryAddressByUserId(userId);
	return list;
	}
	public int saveDeliveryAddress(HttpServletRequest request) {
			String contactName = request. getParameter("contactName");
			String contactSex = request. getParameter( "contactSex" ) ;
			String contactTel = request . getParameter("contactTel");
			String address = request. getParameter( "address");
			String userId = request. getParameter("userId");
			DeliveryAddress da = new DeliveryAddress();
			da.setAddress (address);
			da.setContactName( contactName);
			da.setContactSex(Integer.valueOf(contactSex));
			da.setContactTel(contactTel);
			da.setUserId(userId);
			int count = userAddressService.saveDeliveryAddress(da);
			return count;
	}
	public DeliveryAddress getDeliveryAddressById(HttpServletRequest request) {
		String daId = request.getParameter("daid");
		DeliveryAddress deliveryAddress = userAddressService.getDeliveryAddressById(daId);
		return deliveryAddress;
		
	}

}
