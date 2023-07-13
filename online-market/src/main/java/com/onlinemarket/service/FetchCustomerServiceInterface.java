package com.onlinemarket.service;

import com.onlinemarket.entity.Customers;

public interface FetchCustomerServiceInterface {

	
	Customers fetchCustomer(String customerId);
}
