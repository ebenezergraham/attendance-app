package me.ebenezergraham.qb.rest;
/*
ebenezergraham created on 2/1/19
*/

import me.ebenezergraham.qb.AttendantNotFoundException;
import me.ebenezergraham.qb.repository.AttendanceRecord;
import me.ebenezergraham.qb.repository.AttendanceRepository;
import me.ebenezergraham.qb.repository.Attendant;
import me.ebenezergraham.qb.repository.AttendantRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AttendanceController {
	private final AttendanceRepository repository;
	
	AttendanceController(AttendanceRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/attendance")
	List<AttendanceRecord> all() {
		return repository.findAll();
	}
	
	@PostMapping("/attendance")
	AttendanceRecord newAttendant(@RequestBody AttendanceRecord newAttendant) {
		return repository.save(newAttendant);
	}
	
	// Single item
	
	@GetMapping("/attendance/{id}")
	AttendanceRecord attendant(@PathVariable Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new AttendantNotFoundException(id));
	}
	
	@DeleteMapping("/attendance/{id}")
	void deleteAttendance(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
