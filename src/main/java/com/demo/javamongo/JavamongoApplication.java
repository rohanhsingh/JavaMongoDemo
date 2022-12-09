package com.demo.javamongo;

import com.demo.javamongo.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class JavamongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavamongoApplication.class, args);
	}
}
