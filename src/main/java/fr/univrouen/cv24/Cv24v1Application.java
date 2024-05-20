package fr.univrouen.cv24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.univrouen.cv24.Repository")
@EntityScan("fr.univrouen.cv24.model")
public class Cv24v1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cv24v1Application.class, args);
	}

}
