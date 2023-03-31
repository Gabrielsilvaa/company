package com.gabriel.andrade.company_supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompanySupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanySupplierApplication.class, args);
	}

}
