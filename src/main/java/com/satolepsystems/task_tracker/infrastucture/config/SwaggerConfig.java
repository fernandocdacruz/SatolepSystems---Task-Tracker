package com.satolepsystems.task_tracker.infrastucture.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Tracker API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de tarefas e usuários.")
                        .contact(new Contact()
                                .name("Satolep Systems")
                                .email("suporte@satolepsystems.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }

}
