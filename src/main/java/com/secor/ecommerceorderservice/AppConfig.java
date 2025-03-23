package com.secor.ecommerceorderservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {


    @Bean(name = "auth-service-validate")
    public WebClient webClientAuthService(WebClient.Builder webClientBuilder)
    {
        return webClientBuilder
                .baseUrl("http://localhost:8082/api/v1/validate")
                .filter(new LoggingWebClientFilter())
                .build();
    }

    @Bean(name = "payment-service-create-payment")
    public WebClient webClientPymntService(WebClient.Builder webClientBuilder)
    {
        return webClientBuilder
                .baseUrl("http://localhost:8102/api/v1/create/payment")
                .filter(new LoggingWebClientFilter())
                .build();
    }

    @Bean(name = "product-service-get-product")
    public WebClient webClientOrderService(WebClient.Builder webClientBuilder)
    {
        return webClientBuilder
                .baseUrl("http://localhost:8087/api/v1/get/product")
                .filter(new LoggingWebClientFilter())
                .build();
    }


}
