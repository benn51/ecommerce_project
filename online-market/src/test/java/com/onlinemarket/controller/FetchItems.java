package com.onlinemarket.controller;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.onlinemarket.controller.support.BaseTest;
import com.onlinemarket.entity.Customers;

import lombok.Getter;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

      @SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
      @ActiveProfiles("test")
      @Sql(scripts= {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql", 
       "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
       config= @SqlConfig(encoding="utf-8"))

class FetchItems  {

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

	@Test
	void testFetchitems() {
		

	    String  customerId= "John_Smith";
	    String uri = String.format("%s?customerId=%s", getBaseUriForShoes(), customerId);
	    
	    ResponseEntity <List<Customers>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
			new ParameterizedTypeReference< > () {});
	    
	    
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	  
	    
	    List<Customers>list= new LinkedList<>();
	   
	   
	    list.add(Customers.builder()
	    		.customerPk(1)
	    		.customerId("John_Smith")
	    		.firstName("John")
	    		.lastName("Smith")
	    		.phone("778-655-6555")
	    		.build());
	    
	     List<Customers> actual = response.getBody();
		List<Customers> expected = list;
		System.out.println(actual);
		System.out.println(expected);
		System.out.println(uri);
		assertThat(actual).isEqualTo(expected);
		
		
	}

}
