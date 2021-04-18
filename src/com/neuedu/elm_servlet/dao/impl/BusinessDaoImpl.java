package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.elm_servlet.dao.BusinessDao;
import com.neuedu.elm_servlet.entity.Business;
import com.neuedu.elm_servlet.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao {

	@Override
	public List<Business> listBusinessByOrderTypeId(String orderTypeId) throws Exception{
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT businessId,businessName,businessAddress,"
				+ "businessExplain,businessImg,starPrice,deliveryPrice,remarks FROM `business` WHERE "
				+ "orderTypeId=?");
		ps.setString(1, orderTypeId);
		ArrayList<Business> resultList = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Business business = new Business();
			business.setBusinessId(rs.getInt("businessId"));
			business.setBusinessName(rs.getString("businessName"));
			business.setBusinessAddress(rs.getString("businessAddress"));
			business.setBusinessExplain(rs.getString("businessExplain"));
			business.setStarPrice(rs.getDouble("starPrice"));
			business.setBusinessImg(rs.getString("businessImg"));
			business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			business.setRemarks(rs.getString("remarks"));
			resultList.add(business);
		}
		DBUtil.close(rs, ps);
		return resultList;
	}

	@Override
	public Business getBusinessById(String businessId) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT businessId,businessName,businessAddress,"
				+ "businessExplain,businessImg,starPrice,deliveryPrice,remarks FROM `business` WHERE "
				+ "businessId=?");
		ps.setString(1, businessId);
		Business business = new Business();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			business.setBusinessId(rs.getInt("businessId"));
			business.setBusinessName(rs.getString("businessName"));
			business.setBusinessAddress(rs.getString("businessAddress"));
			business.setBusinessExplain(rs.getString("businessExplain"));
			business.setStarPrice(rs.getDouble("starPrice"));
			business.setBusinessImg(rs.getString("businessImg"));
			business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			business.setRemarks(rs.getString("remarks"));
		}
		DBUtil.close(rs, ps);
		return business;
	}

}
