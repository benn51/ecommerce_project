package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarket.dao.DeleteCustomerDao;

import com.onlinemarket.entity.Customers;


@Service
public class DeleteCustomerService implements DeleteCustomerServiceInterface {

	
   @Autowired	
	DeleteCustomerDao deleteCustomerDao;
	
	@Override
	public Customers deleteCustomer(String customerId) {
		
		return  deleteCustomerDao.deleteCustomer(customerId);
	}


}
