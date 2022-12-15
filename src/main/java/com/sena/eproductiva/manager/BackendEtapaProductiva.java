package com.sena.eproductiva.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class BackendEtapaProductiva {

	public static void main(String[] args) {
		SpringApplication.run(BackendEtapaProductiva.class, args);
	}

}