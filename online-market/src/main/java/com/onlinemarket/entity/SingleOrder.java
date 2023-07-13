package com.onlinemarket.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SingleOrder {

	
		private String customer;
		private String shoe;
		private String cloth;
		private String phone;
	
}
