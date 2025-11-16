package io.backend.bank.transactions.config;

import io.swagger.v3.oas.models.OpenAPI;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringdocConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .packagesToScan("io.backend.bank.transactions.infrastructure.web")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend bank transactions REST API")
                        .description("REST API to handle bank transactions")
                        .version("1.0.0"));
    }

    @GetMapping("/docs")
    public String redirect() {
        return "redirect:/swagger-ui.html";
    }
}
