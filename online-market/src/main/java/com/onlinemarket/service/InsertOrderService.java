package com.onlinemarket.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarket.dao.InsertOrderDao;
import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;
import com.onlinemarket.entity.SingleOrder;
import com.onlinemarket.entity.Catagory;


@Service
public class InsertOrderService implements InsertOrderServiceInterface {

	
	@Autowired
	private InsertOrderDao insertOrderDao;
	
    @Transactional
	@Override
	
	public Orders takeOrder(String customers, String cloths, String shoes, String phones) {
    	
	  Customers customer =getCustomer(customers);
	  Cloths cloth = getCloth(cloths);
	  Phones phone =getPhone(phones);
	  Shoes shoe= getShoe(shoes);

	 
	 // String  clothCatagory   ; //=  cloth.getCatagory().toString();
		// String shoesCatagory ; //= shoe.getCatagory().toString();	
		 //String phoneCatagory ; //= phone.getCatagory().toString();
		 
		 List<String> catagories= new LinkedList<>();
		 List<Integer> IntegerCatagories= new LinkedList<>();
				
		   catagories.add("PERSONAL_WEAR");
		   catagories.add("BEDDING");
		   catagories.add("ELECTRONICS");
		   
		   for(String catagory:catagories) {
			   if(catagory=="PERSONAL_WEAR") {
				   IntegerCatagories.add(1);
			   }
			   else if(catagory =="BEDDING") {
				   IntegerCatagories.add(2);
			   }
			   else {
				   IntegerCatagories.add(3);
			   }
		   }
		  
	  
	 int  price = shoe.getPrice() + cloth.getPrice() + phone.getPrice();
	  
	
	  
	   return insertOrderDao.saveOrder(customer, cloth,  shoe, phone, price, IntegerCatagories);
    }
    

	


	protected Cloths getCloth(String cloth) {
		return insertOrderDao.fetchCloth(cloth)
				  .orElseThrow(()->new NoSuchElementException("cloth with ID= "+ cloth + "was not found"));
	}

	protected Phones getPhone(String phone) {
		return insertOrderDao.fetchPhone(phone)
				  .orElseThrow(()->new NoSuchElementException("phone with ID= "+ phone + "was not found"));
	}

	protected Shoes getShoe(String shoe) {
		return insertOrderDao.fetchShoe(shoe)
				   .orElseThrow(()->new NoSuchElementException("Color with ID= "+ shoe + "was not found"));
	}

	

	protected Customers getCustomer(String customer) {
		return insertOrderDao.fetchCustomer(customer)
			.orElseThrow(()->new NoSuchElementException("Customer with ID= "+ customer + "was not found"));
	}
	
	
	
	
}
