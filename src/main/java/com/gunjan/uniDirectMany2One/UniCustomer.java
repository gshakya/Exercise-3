package com.gunjan.uniDirectMany2One;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UniCustomer {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(cascade= {CascadeType.PERSIST})	
	@JoinColumn(name = "Customer_id")
	private Set<UniReservation> reservation = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addReservation(UniReservation r){
		reservation.add(r);
	}
	
}
