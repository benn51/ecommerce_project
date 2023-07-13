package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Customers;
import com.onlinemarket.service.FetchCustomerService;

@RestController
public class FetchCustomerConroller implements FetchCustomerControllerInterface {
	
	@Autowired
	
	FetchCustomerService  fetchCustomerService;

	@Override
	public Customers fetchCustomer(String customerId) {
		
		return fetchCustomerService.fetchCustomer(customerId);
	}
	

}
