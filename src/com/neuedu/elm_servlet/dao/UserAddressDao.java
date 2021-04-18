package com.neuedu.elm_servlet.dao;

import java.util.List;

import com.neuedu.elm_servlet.entity.DeliveryAddress;

public interface UserAddressDao {

	List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception;

	int saveDeliveryAddress(DeliveryAddress da) throws Exception;

}
