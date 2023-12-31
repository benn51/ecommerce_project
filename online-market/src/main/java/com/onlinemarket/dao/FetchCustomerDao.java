package com.onlinemarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import com.onlinemarket.entity.Customers;

@Component
public class FetchCustomerDao implements FetchCustomerDaoInterface {
	
	@Autowired 
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Customers fetchCustomer(String customerId) {			
		
	      return currentCustomer(customerId);
	      
	}
	
	Customers currentCustomer (String customerId) {
		String sql= " "
				+ "SELECT * FROM customers "
				+ " WHERE customer_id = :customer_id ";
			
		  Map<String, Object> params = new HashMap<>();
		  
		 
		    params.put("customer_id", customerId);
		    
		 
		    
	  return jdbcTemplate.query(sql, params, new CustomerResultSetExtractor());	
		
	     
	}

	
	class CustomerResultSetExtractor implements ResultSetExtractor<Customers> {
		   @Override
		   public Customers extractData(ResultSet rs) throws SQLException {
		     rs.next();

		     // @formatter:off
		     return Customers.builder()
		         .customerId(rs.getString("customer_id"))
		         .firstName(rs.getString("First_name"))
		         .lastName(rs.getString("last_name"))
		         .phone(rs.getString("phone"))		       
		         .build();
		     // @formatter:on
		   }
		 }

}
