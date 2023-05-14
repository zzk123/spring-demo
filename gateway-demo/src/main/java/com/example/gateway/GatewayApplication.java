package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName gatewayApplication
 * @Description TODO
 * @Author zzk
 * @Date 2023/5/14 16:39
 **/
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * uri 配置，转发到对应的uri
     * @param builder
     * @return
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("eureka-client2", r -> r.path("/test/**")
                .uri("http://192.168.1.10:8000/")
                ).build();
    }
}
