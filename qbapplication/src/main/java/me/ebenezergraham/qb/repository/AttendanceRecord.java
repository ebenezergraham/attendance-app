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
	String userId;
	String qrCodeId;
	 String time;
	 String session;
	String username;
	
	public AttendanceRecord() {
	}
	
	public AttendanceRecord(String userId, String qrCodeId, String session, String username) {
		this.userId = userId;
		this.qrCodeId = qrCodeId;
		this.time = LocalTime.now().toString();
		this.session = session;
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getQrCodeId() {
		return qrCodeId;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getSession() {
		return session;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "AttendanceRecord{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", qrCodeId='" + qrCodeId + '\'' +
				", time='" + time + '\'' +
				", session='" + session + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
