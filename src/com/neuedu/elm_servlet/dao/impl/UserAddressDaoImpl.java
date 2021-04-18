package com.neuedu.elm_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.elm_servlet.dao.UserAddressDao;
import com.neuedu.elm_servlet.entity.DeliveryAddress;
import com.neuedu.elm_servlet.util.DBUtil;

public class UserAddressDaoImpl implements UserAddressDao {

	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT daId,contactName,contactSex,contactTel,address  FROM deliveryaddress WHERE userId =?");
		ps.setString(1, userId);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<DeliveryAddress> contactTel = new ArrayList<>();
		while(rs.next()) {
			DeliveryAddress deliveryAddress = new DeliveryAddress();
			deliveryAddress.setContactName(rs.getString("contactName"));
			deliveryAddress.setContactSex(rs.getInt("contactSex"));
			deliveryAddress.setContactTel(rs.getString("contactTel"));
			deliveryAddress.setAddress(rs.getString("address"));
			deliveryAddress.setDaId(rs.getInt("daId"));
			contactTel.add(deliveryAddress);
			
		}
		DBUtil.close(rs, ps);
		return contactTel;
	}

	@Override
	public int saveDeliveryAddress(DeliveryAddress da) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert deliveryaddress values(null,)");
			int count = ps.executeUpdate();
		
		return count;
	}

}
