package me.ebenezergraham.qb;

import me.ebenezergraham.qb.configuration.QbConfiguration;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class QbApplication {
	
	@Autowired
	Logger logger;
	
	public static void main(String[] args) {
		SpringApplication.run(QbConfiguration.class, args);
	}
	
}

