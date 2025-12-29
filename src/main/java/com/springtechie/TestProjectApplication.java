package com.springtechie;

import com.springtechie.service.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
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
@EnableCaching
public class TestProjectApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestProjectApplication.class, args);

		EmployeeService bean1 = context.getBean(EmployeeService.class); //
		System.out.println(bean1.hashCode());
		EmployeeService bean2 = (EmployeeService) context.getBean("employeeService"); //
		System.out.println(bean2.hashCode());
	}
}