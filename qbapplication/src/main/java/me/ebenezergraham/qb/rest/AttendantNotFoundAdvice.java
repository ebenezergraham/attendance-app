package me.ebenezergraham.qb.rest;
/*
ebenezergraham created on 2/1/19
*/

import me.ebenezergraham.qb.AttendantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AttendantNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(AttendantNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String attendantNotFoundHandler(AttendantNotFoundException ex) {
		return ex.getMessage();
	}
}
