package io.beansprout.spooly.clients;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MSClient {
  private final ReactorLoadBalancerExchangeFilterFunction lbFunction;
  private final WebClient.Builder builder;

  public MSClient(ReactorLoadBalancerExchangeFilterFunction lbFunction, WebClient.Builder builder) {
    this.lbFunction = lbFunction;
    this.builder = builder;
  }
}
