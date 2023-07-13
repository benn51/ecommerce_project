package com.onlinemarket.dao;

import com.onlinemarket.entity.Customers;

public interface CreateNewCustomerDaoInterface {

	
	
	Customers createNewCustomer(String customerId, String firstName, String lastName, String phoneNumber);
}

