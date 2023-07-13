package com.onlinemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;
import com.onlinemarket.service.DeleteShoesService;

@RestController
public class DeleteShoesController implements DeleteShoesControllerInterface {
	
	@Autowired
	DeleteShoesService deleteShoesService;

	@Override
	public Shoes deleteShoe(String shoeId) {
		
		return deleteShoesService.deleteShoe(shoeId);
	}

	
	
	
}
