package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.FetchCustomerDao;
import com.onlinemarket.entity.Customers;

@Service
public class FetchCustomerService implements FetchCustomerServiceInterface {
	@Autowired
	
	FetchCustomerDao  fetchCustomerDao;
	
	@Override

	public Customers fetchCustomer(String customerId) {
		
		
		
		return fetchCustomerDao.fetchCustomer(customerId);
	}

}
