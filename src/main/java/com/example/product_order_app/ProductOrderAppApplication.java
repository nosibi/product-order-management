package com.example.product_order_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProductOrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductOrderAppApplication.class, args);
	}

}
