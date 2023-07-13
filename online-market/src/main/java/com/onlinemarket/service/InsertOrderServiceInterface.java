package com.onlinemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.onlinemarket.dao.InsertOrderDao;
import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;
import com.onlinemarket.entity.SingleOrder;

public interface InsertOrderServiceInterface {

	Orders takeOrder(String customer, String cloth, String shoe, String phone);

	

	
	
	
}
