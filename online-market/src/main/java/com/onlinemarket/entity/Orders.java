package com.onlinemarket.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Orders {

	private Long orderPk;
	private Customers customer;
	private Shoes shoes;
	private Cloths cloths;
	private Phones phones;
	List<Integer>catagories;
	private int price;
	
	
	
}









