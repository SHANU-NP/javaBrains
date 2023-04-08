package com.javaBrains.javaBrains.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Setter
@Getter
@Configuration
@ConfigurationProperties(value = "java-brains.properties")
public class JavaBrainsProperties {

    private String serviceBaseUrl;
}
