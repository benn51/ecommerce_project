package com.onlinemarket.service;

import com.onlinemarket.entity.Customers;

public interface CreateNewCustomerServiceInterface {

	Customers createNewCustomer(String customerId, String firstName, String lastName, String phoneNumber);
	
}
