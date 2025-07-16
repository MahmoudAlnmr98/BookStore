package com.bookstore.catalogservice;

import org.springframework.boot.SpringApplication;

public class TestCatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CatalogserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
