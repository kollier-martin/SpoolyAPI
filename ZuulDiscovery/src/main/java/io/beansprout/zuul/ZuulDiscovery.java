// package io.beansprout.zuul;
//
// import com.netflix.discovery.DiscoveryClient;
// import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
// import io.netty.handler.ssl.SslContext;
// import io.netty.handler.ssl.SslContextBuilder;
// import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
// import org.springframework.context.annotation.Bean;
// import org.springframework.http.client.reactive.ReactorClientHttpConnector;
// import org.springframework.web.reactive.function.client.WebClient;
// import reactor.netty.http.client.HttpClient;
//
// import javax.net.ssl.SSLException;
//
// @EnableZuulProxy
// @EnableDiscoveryClient
// @SpringBootApplication
// public class ZuulDiscovery {
//    public static void main(String[] args) {
//        SpringApplication.run(ZuulDiscovery.class, args);
//    }
//
//    @Bean
//    public WebClient createWebClient() throws SSLException {
//        String certificatesTrustStorePath = "C:/Program
// Files/Java/jre1.8.0_311/lib/security/cacerts";
//        System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
//
//        SslContext context = SslContextBuilder.forClient()
//                .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                .build();
//
//        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(context));
//
//        return WebClient
//                .builder()
//                .clientConnector(new ReactorClientHttpConnector(httpClient)).build();
//    }
// }
