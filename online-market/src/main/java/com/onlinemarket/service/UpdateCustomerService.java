package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.UpdateClothDao;
import com.onlinemarket.dao.UpdateCustomerDao;
import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;

@Service
public class UpdateCustomerService implements UpdateCustomerServiceInterface {
	
	@Autowired
	UpdateCustomerDao updateCustomerDao;

	public Customers updateCustomer(String customerId, String  phone) {
		
		return updateCustomerDao.updateCustomer(customerId, phone);
	}

}
