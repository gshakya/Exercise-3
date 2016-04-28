package com.gunjan.uniDirectOne2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@GeneratedValue
	@Id
	private int id;

	private String name;
	
	@OneToMany(cascade= {CascadeType.PERSIST})
	private Set<Reservation> reservations = new HashSet<Reservation>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addReservation(Reservation r){
		reservations.add(r);
	}
	
	
}
