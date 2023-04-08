package com.javaBrains.javaBrains.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class SwaggerUiConfiguration implements WebMvcConfigurer {
    private final JavaBrainsProperties properties;

    public SwaggerUiConfiguration(JavaBrainsProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(properties.getServiceBaseUrl() +"/swagger-ui/")
                .setViewName("forward:/swagger-ui/" + "index.html");
    }
}
