package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.CreateNewCustomerDao;
import com.onlinemarket.entity.Customers;

@Service

public class CreateNewCustomerService implements CreateNewCustomerServiceInterface {
	
	@Autowired

	CreateNewCustomerDao  createCustomerDao;
	@Override

	public Customers createNewCustomer(String customerId, String firstName, String lastName, String phoneNumber) {
		
		
		return createCustomerDao.createNewCustomer( customerId, firstName, lastName, phoneNumber);
	}
	

}
