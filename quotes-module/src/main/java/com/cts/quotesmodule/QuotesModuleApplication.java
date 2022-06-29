package com.cts.quotesmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages={"com.cts"})
@EnableJpaRepositories
public class QuotesModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesModuleApplication.class, args);
	}

}
