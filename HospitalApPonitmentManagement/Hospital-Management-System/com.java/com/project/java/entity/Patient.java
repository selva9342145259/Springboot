package com.project.java.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT_DATA")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// it automatically increment the value of id 
	// a user while booking an appointment not need to specify id
	private int id;
	private String Name;
	private String EmailId;
	private String Phone;
	@Column(nullable = true)
	private String Date;
	@Column(nullable = true, unique = true)
	private String Time;
	
	public Patient() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		this.EmailId = emailId;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		this.Time = time;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", Name=" + Name + ", EmailId=" + EmailId + ", Phone=" + Phone + ", Date=" + Date
				+ ", Time=" + Time + "]";
	}
	
	
	

}
