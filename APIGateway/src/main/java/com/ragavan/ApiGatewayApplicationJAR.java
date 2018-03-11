package com.ragavan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/** @author Ragavan */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApiGatewayApplicationJAR {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplicationJAR.class, args);
  }
}
