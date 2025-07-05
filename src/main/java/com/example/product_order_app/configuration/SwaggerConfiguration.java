package com.example.product_order_app.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("com.example.product_order_app")
                .packagesToScan("com.example.product_order_app")
                .build();
    }
}
