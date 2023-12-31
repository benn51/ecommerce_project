package com.onlinemarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.onlinemarket.entity.Customers;


@Component
public class DeleteCustomerDao implements DeleteCustomersDaoInterface {

	@Autowired
   private 	NamedParameterJdbcTemplate jdbcTemplate;
		
public Customers fetchCustomer(String customerId) {
		
		String sql= " "
				+ "SELECT * FROM customers "
				+ " WHERE customer_id = :customer_id ";
			
		  Map<String, Object> params = new HashMap<>();
		  
		 
		    params.put("customer_id", customerId);
		
	      return jdbcTemplate.query(sql, params, new CustomerResultSetExtractor());
		
	}
	
	@Override
	public Customers deleteCustomer(String customerId) {
		
		SqlParams params = new SqlParams();
		
		//@fromatter:off
		String sql= " "
				+ "DELETE FROM customers "
				+ " WHERE customer_id = :customer_id ";
		//@fromatter:on
		
		params.sql= sql;
		params.source.addValue( "customer_id", customerId) ;
		
		
		Customers customer= new Customers();
		customer = fetchCustomer(customerId);
				
		jdbcTemplate.update(params.sql, params.source);
		
		
	      return  customer;
		
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

	
	
	class SqlParams{
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	      

	    }

}
