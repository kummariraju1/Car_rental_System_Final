package com.deepu.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	private Integer id;
	private Integer days;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Integer id, Integer days) {
		super();
		this.id = id;
		this.days = days;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", days=" + days + "]";
	}

}
