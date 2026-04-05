package com.home.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
This is a convenience annotation that is equivalent to declaring
@SpringBootConfiguration, @EnableAutoConfiguration and @ComponentScan
 */
@SpringBootApplication(scanBasePackages = "com.home.restservice" )
@EnableAspectJAutoProxy
public class AlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

}
