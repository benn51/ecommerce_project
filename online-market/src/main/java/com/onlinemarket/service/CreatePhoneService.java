package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.CreatePhoneDao;
import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Phones;

@Service
public class CreatePhoneService implements CreatePhoneServiceInterface {

	@Autowired
	
	CreatePhoneDao createPhoneDao;
	
	
	@Override
	public Phones takePhoneOrder(String phoneId, String phoneColor, int phoneMemory, int price) {
		
		return createPhoneDao.takePhoneOrder(phoneId,phoneColor, phoneMemory, price);
	}

}
