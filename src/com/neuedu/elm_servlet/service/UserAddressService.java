package com.neuedu.elm_servlet.service;

import java.util.List;

import com.neuedu.elm_servlet.entity.DeliveryAddress;

public interface UserAddressService {

	List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

	int saveDeliveryAddress(DeliveryAddress da);

	DeliveryAddress getDeliveryAddressById(String daId);

}
