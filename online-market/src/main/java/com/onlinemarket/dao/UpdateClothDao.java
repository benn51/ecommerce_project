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


@Component
public class UpdateClothDao implements UpdateClothDaoInterface {

	
	@Autowired 
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Cloths updateCloth(String clothId, int clothPrice) {
		
	SqlParams params= new SqlParams();
		
		//@formmater :off
		
		String sql= ""
				+ "UPDATE cloths "
				+ " SET  cloth_price = :cloth_price  "
				+  " WHERE cloth_Id = :cloth_Id " ;
		
		//@formmater :ofn
		
		
		params.sql= sql;
		params.source.addValue("cloth_Id", clothId);
		params.source.addValue("cloth_price", clothPrice);
		
		 jdbcTemplate.update(params.sql, params.source);
		
		
		return fetchCloth(clothId, clothPrice);
	}
	
	Cloths fetchCloth(String clothId, int clothPrice) {
		
		String sql= " "
				+ "SELECT * FROM cloths "
				+ " WHERE cloth_id = :cloth_id ";
			
		  Map<String, Object> params = new HashMap<>();
		  
		 
		    params.put("cloth_id", clothId);
		
	      return jdbcTemplate.query(sql, params, new ClothResultSetExtractor());

	}
	
	
	
	
	
	class ClothResultSetExtractor implements ResultSetExtractor<Cloths> {
		   @Override
		   public Cloths extractData(ResultSet rs) throws SQLException {
		     rs.next();

		     // @formatter:off
		     return Cloths.builder()
		         .clothId(rs.getString("cloth_id"))
		         .clothColor(rs.getString("cloth_color"))
		         .clothSize(rs.getInt("cloth_size"))
		         .catagory(rs.getString("catagory"))
		         .price(rs.getInt("cloth_price"))		       
		         .build();
		     // @formatter:on
		   }
		 }
	
	
	
	
	class SqlParams{
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	      

	    }

	
}
