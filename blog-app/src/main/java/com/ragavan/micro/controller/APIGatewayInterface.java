package com.ragavan.micro.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("apiGateway")
public interface APIGatewayInterface {
  @RequestMapping("/info")
  String info();
}
