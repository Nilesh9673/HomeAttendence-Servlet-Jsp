package com.jsp.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReportDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int UserId;
	private LocalDate date;
	private LocalTime sign_in;
	private LocalTime sign_out;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getSign_in() {
		return sign_in;
	}

	public void setSign_in(LocalTime sign_in) {
		this.sign_in = sign_in;
	}

	public LocalTime getSign_out() {
		return sign_out;
	}

	public void setSign_out(LocalTime sign_out) {
		this.sign_out = sign_out;
	}

}
