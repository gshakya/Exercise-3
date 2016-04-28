package com.gunjan.model.uniDirectMany2One;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class UniReservation {

	@Id
	@GeneratedValue
	private int id;
	
	private Date date;
	@ManyToOne (cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "book_id")
	private UniBook book;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setBook(UniBook book) {
		this.book = book;
	}
	
	
}
