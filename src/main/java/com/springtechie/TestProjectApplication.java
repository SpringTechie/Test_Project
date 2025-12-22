package com.springtechie;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "TEST APPLICATION",
				version = "1.0",
				description = "This service used to work with employee data"
		)
)
@EnableAsync
@EnableScheduling
public class TestProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}
}