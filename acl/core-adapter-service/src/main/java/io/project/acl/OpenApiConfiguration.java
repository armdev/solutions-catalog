package io.project.acl;


import org.springdoc.core.models.GroupedOpenApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("core-adapter")
                .packagesToScan("io.project")
                .pathsToMatch("/api/**")
                .build();
    }

}
