package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.service.CreateNewCustomerService;
import com.onlinemarket.service.CreatePhoneService;

import lombok.extern.slf4j.Slf4j;


@RestController


public class CreateNewCustomerController implements CreateNewCustomerControllerInterface {
		
	@Autowired

	CreateNewCustomerService  createCustomerService;
	
	@Override
	
	public Customers createNewCustomer(String customerId, String firstName, String lastName, String phoneNumber ) {
		
		return createCustomerService.createNewCustomer( customerId,  firstName, lastName,  phoneNumber);

}
}