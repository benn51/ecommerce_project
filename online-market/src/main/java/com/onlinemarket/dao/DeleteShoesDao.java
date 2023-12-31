package com.onlinemarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.onlinemarket.entity.Shoes;

@Component
public class DeleteShoesDao implements DeleteShoesDaoInterface {

	@Autowired
   private 	NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	
	
public Shoes fetchShoes(String shoeId) {
		
		String sql= " "
				+ "SELECT * FROM shoes "
				+ " WHERE shoe_id = :shoe_id ";
			
		  Map<String, Object> params = new HashMap<>();
		  
		 
		    params.put("shoe_id", shoeId);
		
	      return jdbcTemplate.query(sql, params, new ShoesResultSetExtractor());
		
	}
	
	@Override
	public Shoes deleteShoe(String shoeId) {
		
		SqlParams params = new SqlParams();
		
		//@fromatter:off
		String sql= " "
				+ "DELETE FROM shoes "
				+ " WHERE shoe_id = :shoe_id ";
		//@fromatter:on
		
		params.sql= sql;
		params.source.addValue( "shoe_id", shoeId) ;
		
		
		Shoes shoe= new Shoes();
		shoe = fetchShoes(shoeId);
				
		jdbcTemplate.update(params.sql, params.source);
		
		
	      return  shoe;
		
	}
	
	
	
	
	
	 class ShoesResultSetExtractor implements ResultSetExtractor<Shoes> {
	   @Override
	   public Shoes extractData(ResultSet rs) throws SQLException {
	     rs.next();

	     // @formatter:off
	     return Shoes.builder()
	         .shoeId(rs.getString("shoe_id"))
	         .shoeColor(rs.getString("shoe_color"))
	         .shoeSize(rs.getInt("shoe_size"))
	         .catagory(rs.getString("catagory"))
	         .price(rs.getInt("price"))
	         .build();
	     // @formatter:on
	   }
	 }

	
	
	class SqlParams{
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	      

	    }

}
