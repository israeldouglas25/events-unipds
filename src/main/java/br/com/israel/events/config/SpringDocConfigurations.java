package br.com.israel.events.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Events")
                        .description("Aplicação desenvolvida durante a pós graduação em Java da UniPDS")
                        .contact(new Contact()
                                .name("Israel Douglas")
                                .email("israeldouglas25@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://loja/api/licenca")));
    }


}
