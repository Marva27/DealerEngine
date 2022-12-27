package com.dealerengine.www.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.info(new Info().title("Dealer Engine").description("Spring Boot application to manage dealers")
						.contact(new Contact().name("Srinivasan Ramu").email("srinimarva@gmail.com")));
	}
}
