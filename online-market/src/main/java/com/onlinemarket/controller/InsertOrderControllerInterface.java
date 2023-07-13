package com.onlinemarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Orders;
import com.onlinemarket.entity.Phones;
import com.onlinemarket.entity.Shoes;
import com.onlinemarket.entity.SingleOrder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@RequestMapping("/orders")
@OpenAPIDefinition(info= @Info(title= "insert items"), servers= {
		@Server (url = "http://localhost:8082", description = "Local server.")})

public interface InsertOrderControllerInterface {

	

	//@formatter:off
	@Operation(
			summary = " Create An Order",
			description = "Returns  the Created order ",
			responses = {
				@ApiResponse(responseCode= "201", 
						description = "The Created Jeep is returned ",
						content= @Content(mediaType="application/json", 
						schema= @Schema(implementation= Orders.class))), 
				@ApiResponse(
						responseCode= "400", 
						description = "The Requested paramenters are invalid ", 
						content= @Content(mediaType="application/json")), 
				@ApiResponse(
						responseCode= "404", 
						description = "a  component was not found with the input criteria ", 
						content= @Content(mediaType="application/json")), 
				@ApiResponse(
						responseCode= "500", 
						description = "An unplanned erroe occured ", 
						content= @Content(mediaType="application/json")), 
				
			},
			parameters = {
				@Parameter(name="customer",
					    required = true, 
						description= "The order as JSON "),
				@Parameter(name="cloth",
			    required = true, 
				description= "The order as JSON "),
				
				@Parameter(name="shoe",
			    required = true, 
				description= "The order as JSON "),
				
				@Parameter(name="phone",
			    required = true, 
				description= "The order as JSON ")
				
			}
			) 

	
	@PostMapping
	@ResponseStatus(code= HttpStatus.CREATED)
	
	Orders takeOrder( String customer, String cloth, String shoe, String phone);
	
	
}
