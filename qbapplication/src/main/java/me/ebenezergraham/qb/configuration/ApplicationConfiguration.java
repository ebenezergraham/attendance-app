package me.ebenezergraham.qb.configuration;

import me.ebenezergraham.qb.QbApplication;
import me.ebenezergraham.qb.repository.Attendant;
import me.ebenezergraham.qb.repository.AttendantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
ebenezergraham created on 2/1/19
*/
@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(QbApplication.class);
	}
	
	@Bean
	CommandLineRunner initDatabase(AttendantRepository repository) {
		return args -> {
			logger().info("Preloading " + repository.save(new Attendant("Ebenezer", "student")));
			logger().info("Preloading " + repository.save(new Attendant("Stephen", "facilitator")));
		};
	}
}
