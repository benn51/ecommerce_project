package com.onlinemarket.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

public class BaseTest {

	
	@LocalServerPort

	private int serverPort;

	@Autowired
	@Getter
	private TestRestTemplate restTemplate;

	/**
	 * 
	 * @return
	 */
	protected String getBaseUriForShoes() {
		return String.format("http://localhost:%d/shoes", serverPort);
	}

	/**
	 * 
	 * @return
	 */

	protected String getBaseUriForOrders() {
		return String.format("http://localhost:%d/orders", serverPort);
	}
	
	
	
	
}
