package io.beansprout.discovery;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.security.*;
import javax.net.ssl.SSLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServer.class, args);
  }

  @Bean
  public WebClient createWebClient() throws SSLException {
    SslContext context =
        SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();

    HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(context));

    return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
  }
}
