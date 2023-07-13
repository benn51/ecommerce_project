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


import com.onlinemarket.entity.Cloths;
import com.onlinemarket.entity.Customers;


@Component
public class UpdateCustomerDao implements UpdateCustomerDaoInterface {

	
	@Autowired 
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Customers updateCustomer(String customerId, String phone) {
		
	SqlParams params= new SqlParams();
		
		//@formmater :off
		
		String sql= ""
				+ "UPDATE customers "
				+ " SET  phone = :phone  "
				+  " WHERE customer_Id = :customer_Id " ;
		
		//@formmater :ofn
		
		
		params.sql= sql;
		params.source.addValue("customer_Id", customerId);
		params.source.addValue("phone", phone);
		
		 jdbcTemplate.update(params.sql, params.source);
		
		
		return fetchCustomer(customerId, phone);
	}
	
	Customers fetchCustomer(String customerId, String phone) {
		
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
	
	
	
	
	class SqlParams{
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	      

	    }

	
}
