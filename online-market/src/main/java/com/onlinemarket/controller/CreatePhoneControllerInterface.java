package com.onlinemarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Orders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import com.onlinemarket.entity.Phones;



@RequestMapping("/phones")
@OpenAPIDefinition(info= @Info(title= "create phone"), servers= {
		@Server (url = "http://localhost:8082", description = "Local server.")})

public interface CreatePhoneControllerInterface {

	
	//@formatter:off
		@Operation(
				summary = " Create a new phone",
				description = "Returns  the Created phone ",
				responses = {
					@ApiResponse(responseCode= "201", 
							description = "The Created phone is returned ",
							content= @Content(mediaType="application/json", 
							schema= @Schema(implementation= Phones.class))), 
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
				
					@Parameter(name="phoneId",
				    required = true, 
					description= "The order as JSON "),
					
					@Parameter(name="phoneColor",
				    required = true, 
					description= "The order as JSON "),
					
					@Parameter(name="phoneMemory",
				    required = true, 
					description= "The order as JSON "),
					
					@Parameter(name="price",
				    required = true, 
					description= "The order as JSON ")
					
				}
				) 

		
		@PostMapping
		@ResponseStatus(code= HttpStatus.CREATED)
		
		Phones takePhoneOrder( String phoneId ,String phoneColor, int phoneMemory,  int price);
	
	
		
	
	
}
