package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Cloths;
import com.onlinemarket.service.UpdateClothService;

@RestController

public class UpdateClothController implements UpdateClothControllerInterface {

	@Autowired
	UpdateClothService updateClothService;
	
	
	@Override
	public Cloths updateCloth(String clothId, int clothPrice) {
		
		return updateClothService.updateCloth(clothId,clothPrice);
	}

}
