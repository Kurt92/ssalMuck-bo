package com.ssalMuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class SsalMuckApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsalMuckApplication.class, args);
	}

}
