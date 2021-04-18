package com.neuedu.elm_servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.elm_servlet.entity.Business;
import com.neuedu.elm_servlet.service.BusinessService;
import com.neuedu.elm_servlet.service.impl.BusinessServiceImpl;

public class BusinessController {
	
	private BusinessService businessService = new BusinessServiceImpl();
	
	/**
	 * 获取商家列表信息
	 * @param request
	 * @return 
	 */
	public List<Business> listBusinessByOrderTypeId(HttpServletRequest request){
		//获取参数
		String orderTypeId = request.getParameter("orderTypeId");
		
		//调用service
		List<Business> businesslist = businessService.listBusinessByOrderTypeId(orderTypeId);
		
		//返回数据
		return businesslist;
	}
	
	
	/**
	 * 获取单个商家信息
	 * @param request
	 * @return
	 */
	public Business getBusinessById(HttpServletRequest request){
		
		String businessId = request.getParameter("businessId");
		
		Business business = businessService.getBusinessById(businessId);
		
		return business;
	}
	

}
