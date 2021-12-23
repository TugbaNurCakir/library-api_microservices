package com.example.registrationapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import java.time.Duration;

@Configuration
public class ApplicationConfigurations {
    @Bean
    public RestTemplate userApiTemplate(RestTemplateBuilder builder, @Value("client.user.url") String url ){
        return builder
                .setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .uriTemplateHandler(new DefaultUriBuilderFactory(url))
                .build();
    }

    @Bean
    public RestTemplate libraryApiTemplate(RestTemplateBuilder builder, @Value("client.library.url") String url ){
        return builder
                .setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(2))
                .uriTemplateHandler(new DefaultUriBuilderFactory(url))
                .build();
    }
}
