package com.onlinemarket.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Phones;

public interface CreatePhoneDaoInterface {

	Phones takePhoneOrder(String phoneId, String phoneColor, int phoneMemory, int price);
	


}
