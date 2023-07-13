package com.onlinemarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shoes {

	private Integer shoePk;
	private String shoeId;
	private String shoeColor;
	private Integer shoeSize;
	private  String catagory;;
	private int price;
	
	
	
	@JsonIgnore
	public Integer getShoePk () {
		return shoePk;
	}
}


