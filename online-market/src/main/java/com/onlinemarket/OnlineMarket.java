package com.onlinemarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class OnlineMarket {

	public static void main(String[] args) {
    SpringApplication.run(OnlineMarket.class, args);
    log.info("hello spring boot");
   
   
    
	}

}
