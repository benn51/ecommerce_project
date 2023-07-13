package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Customers;

import com.onlinemarket.service.DeleteCustomerService;


@RestController
public class DeleteCustomerController implements DeleteCustomerControllerInterface {
	
	@Autowired
	DeleteCustomerService deleteCustomerService;

	@Override
	public Customers deleteShoe(String customerId) {
		
		return deleteCustomerService.deleteCustomer(customerId);
	}

	
	
	
}
