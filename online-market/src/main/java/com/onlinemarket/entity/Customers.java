package com.onlinemarket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Customers {

	private int customerPk;
	private String customerId;
	private String firstName;
	private String lastName;
	private String phone;
	
}

