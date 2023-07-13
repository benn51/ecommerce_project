package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.UpdateClothDao;
import com.onlinemarket.entity.Cloths;

@Service
public class UpdateClothService implements UpdateClothServiceInterface {
	
	@Autowired
	UpdateClothDao updateClothDao;

	public Cloths updateCloth(String clothId,int clothPrice) {
		
		return updateClothDao.updateCloth(clothId, clothPrice);
	}

}
