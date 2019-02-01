package me.ebenezergraham.qb.repository;
/*
ebenezergraham created on 2/1/19
*/


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AttendanceRecord {
	
	private @Id @GeneratedValue
	Long id;
	final int userId;
	final int qrCodeId;
	final String time;
	final String session;
	
	public AttendanceRecord(int userId, int qrCodeId,String session) {
		this.userId = userId;
		this.qrCodeId = qrCodeId;
		this.time = LocalTime.now().toString();
		this.session = session;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getQrCodeId() {
		return qrCodeId;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getSession() {
		return session;
	}
}
