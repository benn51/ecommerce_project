package com.onlinemarket.service;

import org.springframework.stereotype.Service;

import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;


public interface CreatePhoneServiceInterface {


	public Phones takePhoneOrder(String phoneId, String phoneColor, int phoneMemory, int price) ;
		
		
	
}
