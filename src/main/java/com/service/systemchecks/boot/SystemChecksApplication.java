package com.service.systemchecks.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.service.systemchecks" })
public class SystemChecksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemChecksApplication.class, args);
	}

}
