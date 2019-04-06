package me.ebenezergraham.qb.rest;

import me.ebenezergraham.qb.repository.AttendanceRecord;
import me.ebenezergraham.qb.repository.AttendanceRepository;
import me.ebenezergraham.qb.services.AttendanceService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/v1/attendant")
public class MailController {
	
	AttendanceService attendanceService;
	AttendanceRepository attendanceRepository;
	Logger logger;
	
	@Autowired
	MailController(final AttendanceService attendanceService,
	               final AttendanceRepository attendanceRepository,
	               final Logger logger) {
		this.attendanceService = attendanceService;
		this.attendanceRepository = attendanceRepository;
		this.logger = logger;
	}
	
	@RequestMapping(value = "/checkin/{qrCodeId}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	AttendanceRecord checkin(@RequestBody AttendanceRecord record, @PathVariable String qrCodeId) {
		logger.info("QRCode In: {}", qrCodeId);
		logger.info(record.toString());
		return attendanceRepository.save(record);
	}
	
	@PostMapping("/checkout/{qrCodeId}")
	AttendanceRecord checkout(@RequestBody AttendanceRecord record, @PathVariable String qrCodeId) {
		logger.info("QRCode In: {}", qrCodeId);
		return attendanceRepository.save(record);
	}
}
