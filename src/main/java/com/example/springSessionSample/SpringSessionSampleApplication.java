package com.example.springSessionSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableCaching
public class SpringSessionSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSessionSampleApplication.class, args);
		System.out.print("Hello World and welcome to spring 2.0");
	}

}
 