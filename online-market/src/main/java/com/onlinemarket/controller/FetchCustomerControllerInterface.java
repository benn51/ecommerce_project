package com.onlinemarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinemarket.entity.Customers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@RequestMapping("/customers")
@OpenAPIDefinition(info= @Info(title= "fetch customer"), servers= {
		@Server (url = "http://localhost:8082", description = "Local server.")})

public interface FetchCustomerControllerInterface {	
	
				//@formatter:off
				@Operation(
						summary = " Fetch customer",
						description = "Returns a customer ",
						responses = {
							@ApiResponse(responseCode= "201", 
									description = "The Requested customer is returned ",
									content= @Content(mediaType="application/json", 
									schema= @Schema(implementation= Customers.class))), 
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
							@Parameter(name="customerId",
								    required = true, 
									description= "The order as JSON ")
														
						}
						) 

				
				@GetMapping
				@ResponseStatus(code= HttpStatus.CREATED)
				
			Customers fetchCustomer(String customerId);
			

}
