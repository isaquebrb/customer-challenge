package br.com.isaquebrb.customerchallenge.adapter.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI probeChallengeOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Customer Challenge API")
                        .description("Customer Challenge application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Customer Challenge Github Documentation")
                        .url("https://github.com/isaquebrb/customer-challenge"));
    }
}
