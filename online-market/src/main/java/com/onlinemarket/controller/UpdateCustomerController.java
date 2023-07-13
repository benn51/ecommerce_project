package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.service.UpdateClothService;
import com.onlinemarket.service.UpdateCustomerService;

@RestController

public class UpdateCustomerController implements UpdateCustomerControllerInterface {

	@Autowired
	UpdateCustomerService updateCustomerService;
	
	
	@Override
	public Customers updateCustomer(String customerId, String phone) {
		
		return updateCustomerService.updateCustomer(customerId,phone);
	}

}
