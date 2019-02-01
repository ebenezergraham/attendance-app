package me.ebenezergraham.qb;

import me.ebenezergraham.qb.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class QbApplication {

	public static void main(String[] args) {
		SpringApplication.run(QbApplication.class, args);
	}

}

