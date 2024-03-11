package com.muchiri.plainjdbc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.muchiri.plainjdbc.domain.Customer;
import com.muchiri.plainjdbc.service.CustomerService;

@SpringBootApplication
public class PlainJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlainJdbcApplication.class, args);
	}

	// @Bean
	// ApplicationRunner runner(CustomerService customerService) {
	// 	return args -> {
	// 		System.out.println("creating a customer");
	// 		Customer cust = customerService.create("John", 2003);
	// 		System.out.println(cust);
	// 		System.out.println("done");
	// 	};
	// }

}
