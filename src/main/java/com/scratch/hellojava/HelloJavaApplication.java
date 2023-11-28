package com.scratch.hellojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HelloJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJavaApplication.class, args);
		log.info("Hello World!");
	}

}
