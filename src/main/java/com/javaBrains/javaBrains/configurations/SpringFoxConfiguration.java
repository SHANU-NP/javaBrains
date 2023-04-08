package com.javaBrains.javaBrains.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SpringFoxConfiguration{

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javaBrains.javaBrains.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

   private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java Brains Microservice")
                .description("This is a Java Brains microservice.")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("","", "abc@gamail.com"))
                .build();
    }

}
