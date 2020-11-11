package br.com.ever.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients 
public class FinMsMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinMsMainApplication.class, args);
	}

}
