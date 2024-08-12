package com.application.sistemaSkill.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfig {
	@Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                    .allowedHeaders("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
            }
        };
    }	
	@Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("PROJETO SISTEMA DE SKILLS")
                        .description("Documentação da API da aplicação Skill Badge."));
    }

	@Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
