package me.ebenezergraham.qb;
/*
ebenezergraham created on 2/1/19
*/
public class AttendantNotFoundException extends RuntimeException {
	
	public AttendantNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
