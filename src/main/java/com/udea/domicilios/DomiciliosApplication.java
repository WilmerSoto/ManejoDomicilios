package com.udea.domicilios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan({
		"com.udea.domicilios.controller",
		"com.udea.domicilios.dao",
		"com.udea.domicilios.model",
		"com.udea.domicilios.service"
})

@EnableJpaRepositories(basePackages = "com.udea.domicilios.dao")
@EntityScan(basePackages = "com.udea.domicilios.model")
public class DomiciliosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomiciliosApplication.class, args);
	}

}
