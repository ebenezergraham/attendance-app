package me.ebenezergraham.qb.rest;

import me.ebenezergraham.qb.services.AttendanceService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("attendance")
public class RestController{
	
	AttendanceService attendanceService;
	Logger logger;
	
	@Autowired
	RestController(final AttendanceService attendanceService,
	                       final Logger logger) {
		this.attendanceService = attendanceService;
		this.logger = logger;
	}
	
	@RequestMapping(
			value = "/{checkin}",
			method = RequestMethod.POST,
			produces = "application/json",
			consumes = "application/json"
	)
	public ResponseEntity<String> checkin(@PathVariable("checkin") String checkin) {
		logger.debug("Checked In: {}", checkin);
		return ResponseEntity.ok("response");
	}
}
