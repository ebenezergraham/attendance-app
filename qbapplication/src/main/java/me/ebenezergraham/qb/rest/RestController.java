package me.ebenezergraham.qb.rest;

import me.ebenezergraham.qb.repository.AttendanceRecord;
import me.ebenezergraham.qb.repository.AttendanceRepository;
import me.ebenezergraham.qb.repository.Attendant;
import me.ebenezergraham.qb.repository.AttendantRepository;
import me.ebenezergraham.qb.services.AttendanceService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/attendant")
public class RestController{
	
	AttendanceService attendanceService;
	AttendanceRepository attendanceRepository;
	Logger logger;
	
	@Autowired
	RestController(final AttendanceService attendanceService,
	               final AttendanceRepository attendanceRepository,
	               final Logger logger) {
		this.attendanceService = attendanceService;
		this.attendanceRepository = attendanceRepository;
		this.logger = logger;
	}
	
	@PostMapping("/checkin/{qrCodeId}")
	AttendanceRecord checkin(@RequestBody AttendanceRecord record, @PathVariable String qrCodeId) {
		logger.info("QRCode In: {}", qrCodeId);
		return attendanceRepository.save(record);
	}
	
	@PostMapping("/checkout/{qrCodeId}")
	AttendanceRecord checkout(@RequestBody AttendanceRecord record, @PathVariable String qrCodeId) {
		logger.info("QRCode In: {}", qrCodeId);
		return attendanceRepository.save(record);
	}
}
