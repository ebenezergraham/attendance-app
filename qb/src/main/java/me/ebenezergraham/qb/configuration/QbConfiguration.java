package me.ebenezergraham.qb.configuration;
/*
ebenezergraham created on 1/31/19
*/

import me.ebenezergraham.qb.QbApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class QbConfiguration {
	
	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(QbApplication.class);
	}
}
