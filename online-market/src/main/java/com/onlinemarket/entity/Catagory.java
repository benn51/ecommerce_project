package com.onlinemarket.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Catagory {
	
private int catagoryPk;
private String catagoryId;
private CatagoryType catagoryType;
	
	
}
	
	
