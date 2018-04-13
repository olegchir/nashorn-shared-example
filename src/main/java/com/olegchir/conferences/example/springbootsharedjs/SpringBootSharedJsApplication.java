package com.olegchir.conferences.example.springbootsharedjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

@SpringBootApplication
public class SpringBootSharedJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSharedJsApplication.class, args);
	}

	@Bean
	public MainController mainController() {
	    return new MainController();
    }
}
