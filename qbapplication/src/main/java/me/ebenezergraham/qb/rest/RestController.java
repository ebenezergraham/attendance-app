package me.ebenezergraham.qb.rest;

import me.ebenezergraham.qb.repository.AttendanceRecord;
import me.ebenezergraham.qb.repository.AttendanceRepository;
import me.ebenezergraham.qb.repository.Attendant;
import me.ebenezergraham.qb.repository.AttendantRepository;
import me.ebenezergraham.qb.services.AttendanceService;
import me.ebenezergraham.qb.services.EmailService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/v1/mail")
public class RestController{
	
	EmailService emailService;
	Logger logger;
	
	@Autowired
	RestController(final EmailService emailService,
	               final Logger logger) {
		this.emailService = emailService;
		this.logger = logger;
	}
	
	@RequestMapping(value = "/plain", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	void checkin() {
		logger.info("Mail sent");
		String [] array = new String[1];
		array[0]="aomondi15@alustudent.com";
		this.emailService.sendPlainTextMail("ebenezergraham69@gmail.com",array,array, LocalDate.now().toString(),"Testing attachement");
	}
}
