package com.neuedu.elm_servlet.service;

import java.util.List;

import com.neuedu.elm_servlet.entity.Business;

public interface BusinessService {
	
	public List<Business> listBusinessByOrderTypeId(String orderTypeId);

	public Business getBusinessById(String businessId);

}
