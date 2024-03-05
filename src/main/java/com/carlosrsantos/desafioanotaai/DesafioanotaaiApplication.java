package com.carlosrsantos.desafioanotaai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DesafioanotaaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioanotaaiApplication.class, args);
	}

}
