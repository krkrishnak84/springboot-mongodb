package com.radhatechie.springboot.mongodb;

import com.radhatechie.springboot.mongodb.entity.Address;
import com.radhatechie.springboot.mongodb.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.radhatechie.springboot.mongodb.entity.Gender.MALE;

@SpringBootApplication
public class SpringbootMongodbApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address("INDIA","522647","VNK");
			List<String> subjects = new ArrayList<>();
			subjects.add("Maths");
			subjects.add("Computer Science, History");

			Student student  = new Student(
					"Radhakrishna",
					"Kuchi",
					"kuchi.radha@gmail.com",
					MALE,
					address,
					subjects,
					BigDecimal.TEN,
					LocalDateTime.now());

			repository.insert(student);
		};
    }
}
