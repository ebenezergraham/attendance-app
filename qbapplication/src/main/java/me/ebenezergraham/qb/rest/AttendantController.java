package me.ebenezergraham.qb.rest;
/*
ebenezergraham created on 2/1/19
*/

import me.ebenezergraham.qb.AttendantNotFoundException;
import me.ebenezergraham.qb.repository.Attendant;
import me.ebenezergraham.qb.repository.AttendantRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendantController {
	private final AttendantRepository repository;
	
	AttendantController(AttendantRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/attendant")
	List<Attendant> all() {
		return repository.findAll();
	}
	
	@PostMapping("/attendant")
	Attendant newAttendant(@RequestBody Attendant newAttendant) {
		return repository.save(newAttendant);
	}
	
	// Single item
	
	@GetMapping("/attendant/{id}")
	Attendant attendant(@PathVariable Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new AttendantNotFoundException(id));
	}
	
	@PutMapping("/attendant/{id}")
	Attendant replaceAttendant(@RequestBody Attendant newAttendant, @PathVariable Long id) {
		
		return repository.findById(id)
				.map(employee -> {
					employee.setName(newAttendant.getName());
					employee.setRole(newAttendant.getRole());
					return repository.save(employee);
				})
				.orElseGet(() -> {
					newAttendant.setId(id);
					return repository.save(newAttendant);
				});
	}
	
	@DeleteMapping("/attendant/{id}")
	void deleteAttendant(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
