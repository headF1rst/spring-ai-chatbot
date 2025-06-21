package org.example.springaichatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring AI Chatbot API")
                        .version("1.0")
                        .description("API documentation for Spring AI Chatbot"));
    }

    @Bean
    public GroupedOpenApi chatbotApi() {
        return GroupedOpenApi.builder()
                .group("chatbot-api")
                .packagesToScan("org.example.springaichatbot.controller")
                .packagesToExclude("org.example.springaichatbot.exception")
                .build();
    }
}
