package com.gateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

	@Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

   

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("DEMOCHECK", r -> r.path("/admin/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter.apply(
                                new JwtAuthenticationFilter.Config("ADMIN"))))
                        .uri("lb://DEMOCHECK"))
                .route("DEMOCHECK", r -> r.path("/users/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter.apply(
                                new JwtAuthenticationFilter.Config("USER"))))
                        .uri("lb://DEMOCHECK"))
                .build();
    }
}
