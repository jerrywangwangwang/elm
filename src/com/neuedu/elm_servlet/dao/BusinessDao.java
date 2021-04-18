package com.neuedu.elm_servlet.dao;

import java.util.List;

import com.neuedu.elm_servlet.entity.Business;

public interface BusinessDao {

	List<Business> listBusinessByOrderTypeId(String orderTypeId) throws Exception;

	Business getBusinessById(String businessId) throws Exception;

}
