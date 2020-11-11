package br.com.ever.fineureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FinEurekaDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinEurekaDiscoveryServiceApplication.class, args);
	}

}
