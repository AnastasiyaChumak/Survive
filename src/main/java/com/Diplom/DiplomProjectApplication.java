package com.Diplom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@ComponentScan(basePackages = "com.Diplom.repositories")
@SpringBootApplication
public class DiplomProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomProjectApplication.class, args);
	}

}
