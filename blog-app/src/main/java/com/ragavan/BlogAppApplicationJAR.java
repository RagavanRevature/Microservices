package com.ragavan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/** @author Ragavan */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BlogAppApplicationJAR {

  public static void main(String[] args) {
    SpringApplication.run(BlogAppApplicationJAR.class, args);
  }
}
