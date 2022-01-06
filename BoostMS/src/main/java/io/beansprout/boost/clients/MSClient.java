package io.beansprout.boost.clients;

import io.beansprout.boost.DTOs.ManufacturerDTO;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Load balanced Web Client for cross-service communication
 * @author Kollier Martin
 * @date 1/6/2021
 */
@Component
public class MSClient {
    @LoadBalanced
    private final WebClient.Builder builder;

    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public MSClient(ReactorLoadBalancerExchangeFilterFunction lbFunction, WebClient.Builder builder) {
        this.lbFunction = lbFunction;
        this.builder = builder;
    }

    public ManufacturerDTO getManufacturer(String name){
        return builder
                .filter(lbFunction)
                .build()
                .get()
                .uri("https://ManufacturerMS/" + name)
                .retrieve()
                .bodyToMono(ManufacturerDTO.class)
                .block();
    }
}
