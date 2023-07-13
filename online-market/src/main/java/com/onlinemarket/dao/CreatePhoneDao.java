package com.onlinemarket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.onlinemarket.dao.InsertOrderDao.SqlParams;
import com.onlinemarket.entity.CatagoryType;
import com.onlinemarket.entity.Phones;

@Component

public class CreatePhoneDao implements CreatePhoneDaoInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Phones takePhoneOrder(String phoneId, String phoneColor, int phoneMemory, int price) {
		
		
		//@formtter off
		
		String sql= " INSERT INTO phones ( " 
				   + "  phone_id, phone_color, phone_memory, "
				   + "   phone_price  "
				   +    " ) "
				   + " VALUES  ( :phone_id, :phone_color, :phone_memory,"
				   + " :phone_price "
				   + " ) "	;	
		//@formtter on
		
		String catagory= "ELECTONICS";
		 SqlParams params = new SqlParams();
		    
		    params.sql = sql;
		    params.source.addValue("phone_id", phoneId );
		    params.source.addValue("phone_color", phoneColor);
		    params.source.addValue("phone_memory", phoneMemory);
		    params.source.addValue("phone_price",price);
		  
		    
		   
		    
		    jdbcTemplate.update(params.sql,params.source);
		    
		    
		    return Phones.builder()
		    		.phoneId(phoneId)
		    		.phoneColor(phoneColor)
		    		.phoneMemory(phoneMemory)
		    		.price(price)
		    		.catagory(catagory)
		    		.build();		
	
	}

	
	class SqlParams{
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	      

	    }
	
}
