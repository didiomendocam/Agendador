package com.cvc.agendador;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@OpenAPIDefinition
@EnableWebMvc
@EntityScan({ "com.cvc.agendador.model" })
@EnableJpaRepositories({ "com.cvc.agendador.repository" })
@ComponentScan(basePackages = "com.cvc.agendador")
public class AgendadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorApplication.class, args);
	}

}
