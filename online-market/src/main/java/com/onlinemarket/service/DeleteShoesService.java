package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.DeleteShoesDao;
import com.onlinemarket.entity.Shoes;

@Service
public class DeleteShoesService implements DeleteShoesServiceInterface {

	
   @Autowired	
	DeleteShoesDao deleteShoesDao;
	
	@Override
	public Shoes deleteShoe(String shoeId) {
		
		return  deleteShoesDao.deleteShoe(shoeId);
	}


}
