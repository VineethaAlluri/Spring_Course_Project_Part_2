package com.hirewheelsproject;


import com.hirewheelsproject.services.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HirewheelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HirewheelsApplication.class, args);
	}

	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.init();
		};
	}

}
