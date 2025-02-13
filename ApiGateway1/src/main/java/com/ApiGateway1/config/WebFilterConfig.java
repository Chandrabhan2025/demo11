package com.ApiGateway1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

import com.ApiGateway1.filter.JwtAuthenticationFilter;


//@Configuration
public class WebFilterConfig {

    @Bean
    public WebFilter headerModificationFilter() {
        return new JwtAuthenticationFilter();
    }
}
