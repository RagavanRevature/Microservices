package com.ragavan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Ragavan
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplicationJAR {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplicationJAR.class, args);
	}
}
