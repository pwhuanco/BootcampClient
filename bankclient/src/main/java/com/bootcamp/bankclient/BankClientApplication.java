package com.bootcamp.bankclient;

import com.bootcamp.bankclient.controller.ClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankClientApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankClientApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("--Iniciando BankClientApplication--");

        SpringApplication.run(BankClientApplication.class, args);
    }

}
