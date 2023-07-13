package com.onlinemarket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.onlinemarket.dao.CreatePhoneDao.SqlParams;
import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Customers;
import com.onlinemarket.entity.Phones;

@Component
public class CreateNewCustomerDao implements CreateNewCustomerDaoInterface {
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
@Override
	public Customers createNewCustomer(String customerId, String firstName, String lastName, String phoneNumber) {
	
		
	String sql= " INSERT INTO customers ( " 
			   + "  customer_id, First_name, last_name, "
			   + "   phone "
			   +    " ) "
			   + " VALUES  ( :customer_id, :First_name, :last_name, "
			   + " :phone "
			   + " ) "	;	
	//@formtter on
	
	 SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("customer_id", customerId );
	    params.source.addValue("First_name", firstName);
	    params.source.addValue("last_name", lastName);
	    params.source.addValue("phone",phoneNumber);
	   // params.source.addValue("catagory", null);
	    
	   
	    
	    jdbcTemplate.update(params.sql,params.source);
	    
	    
	    return Customers.builder()
	    		.customerId(customerId)
	    		.firstName(firstName)
	    		.lastName(lastName)
	    		.phone(phoneNumber)
	    		.build();		

}


class SqlParams{
	String sql;
	MapSqlParameterSource source = new MapSqlParameterSource();
   

 }
	
	
	
	
	

}
