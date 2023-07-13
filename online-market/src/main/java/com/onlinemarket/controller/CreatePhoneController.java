package com.onlinemarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import org.springframework.beans.factory.annotation.Autowired;
import com.onlinemarket.service.CreatePhoneService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j


public class CreatePhoneController implements CreatePhoneControllerInterface {

	@Autowired

	CreatePhoneService  createPhoneService;
		
	
	
	
	@Override
	public Phones takePhoneOrder(String phoneId, String phoneColor, int phoneMemory, int price) {
		
		return createPhoneService.takePhoneOrder(phoneId, phoneColor, phoneMemory, price);
	}

}
