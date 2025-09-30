package com.ecommerce.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.ecommerce.commons.configs",
        "com.ecommerce.commons.connectors",
        "com.ecommerce.commons.controllers",
        "com.ecommerce.commons.enums",
        "com.ecommerce.commons.events",
        "com.ecommerce.commons.exception",
        "com.ecommerce.commons.exception.handler",
        "com.ecommerce.commons.model",
        "com.ecommerce.commons.model.auth",
        "com.ecommerce.commons.model.base",
        "com.ecommerce.commons.orders",
        "com.ecommerce.commons.payments",
        "com.ecommerce.commons.products",
        "com.ecommerce.commons.security",
        "com.ecommerce.commons.security.jwt",
        "com.ecommerce.commons.security.jwt.config",
        "com.ecommerce.commons.security.jwt.filter",
        "com.ecommerce.commons.users",
        "com.ecommerce.commons.utils"
})
@SpringBootApplication
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

}
