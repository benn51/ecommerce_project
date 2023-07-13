package com.onlinemarket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor


public class Phones {
	
private int phonePk;
private String phoneId;
private String phoneColor;
private int phoneMemory;
private String catagory;
private int price;
	
	
	
}
