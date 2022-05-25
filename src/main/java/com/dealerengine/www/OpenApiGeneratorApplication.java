package com.dealerengine.www;

import com.fasterxml.jackson.databind.Module;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dealerengine.www", "com.dealerengine.www.api" , "org.openapitools.configuration"})
@SecurityScheme(name = "bearerAuth", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}