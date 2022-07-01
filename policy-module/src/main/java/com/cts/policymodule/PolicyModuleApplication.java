package com.cts.policymodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.cts"})
@EnableJpaRepositories
public class PolicyModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyModuleApplication.class, args);
    }

}
