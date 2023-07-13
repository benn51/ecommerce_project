package com.onlinemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;
import com.onlinemarket.entity.SingleOrder;

import com.onlinemarket.service.InsertOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InsertOrderController implements InsertOrderControllerInterface  {

	
	@Autowired
	private InsertOrderService insertOrderService;
	
	@Override
	public Orders takeOrder(String customer, String cloth, String shoe, String phone ) {
		
	log.debug("Order={}", "this is th econtroller");
		return insertOrderService.takeOrder( customer, cloth,  shoe, phone);
	}
	
	
}
