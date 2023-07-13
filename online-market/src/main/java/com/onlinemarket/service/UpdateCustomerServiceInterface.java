package com.onlinemarket.service;

import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;

public interface UpdateCustomerServiceInterface {

	public Customers updateCustomer(String customerId, String phone );
}
