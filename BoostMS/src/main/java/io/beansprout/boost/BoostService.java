package io.beansprout.boost;

import com.netflix.discovery.DiscoveryClient.DiscoveryClientOptionalArgs;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import java.security.NoSuchAlgorithmException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class BoostService {
  public static void main(String[] args) {
    SpringApplication.run(BoostService.class, args);
  }

  @Bean
  public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
    DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();

    EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder =
        new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
    builder.withClientName("BoostMS");
    builder.withSystemSSLConfiguration();
    builder.withMaxTotalConnections(10);
    builder.withMaxConnectionsPerHost(10);
    args.setEurekaJerseyClient(builder.build());

    return args;
  }
}
