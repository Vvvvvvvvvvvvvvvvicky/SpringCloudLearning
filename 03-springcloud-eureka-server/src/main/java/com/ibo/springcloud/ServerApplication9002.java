package com.ibo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerApplication9002 {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication9002.class, args);
	}

}
