package com.neuedu.elm_servlet.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.elm_servlet.dao.BusinessDao;
import com.neuedu.elm_servlet.dao.impl.BusinessDaoImpl;
import com.neuedu.elm_servlet.entity.Business;
import com.neuedu.elm_servlet.service.BusinessService;
import com.neuedu.elm_servlet.util.DBUtil;

public class BusinessServiceImpl implements BusinessService {
	
	BusinessDao businessDao = new BusinessDaoImpl();

	@Override
	public List<Business> listBusinessByOrderTypeId(String orderTypeId) {
		//调用dao层查询
		List<Business> businessList = null;
		//获取连接
		Connection con = DBUtil.getConnection();
		try {
			businessList = businessDao.listBusinessByOrderTypeId(orderTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con);
		}
		return businessList;
	}

	@Override
	public Business getBusinessById(String businessId) {
		//获取连接
		Connection con = DBUtil.getConnection();
		
		Business business = null;
		try {
			business = businessDao.getBusinessById(businessId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(con);
		}
		return business;
	}

}
