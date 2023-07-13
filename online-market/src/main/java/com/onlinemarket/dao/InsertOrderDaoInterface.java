package com.onlinemarket.dao;

import java.util.List;
import java.util.Optional;

import com.onlinemarket.entity.Catagory;
import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;

public interface InsertOrderDaoInterface {

	
	Optional<Customers> fetchCustomer(String customer);
	Optional <Cloths> fetchCloth( String cloth);
	Optional <Shoes> fetchShoe(String shoe);
	Optional <Phones> fetchPhone(String phone);
	Orders saveOrder(Customers customer, Cloths cloth, Shoes shoe, Phones phone, int price,List<Integer>catagories );
	List<String> fetchCatagory(Cloths cloth, Shoes shoe, Phones phone);
	

	
	
}
