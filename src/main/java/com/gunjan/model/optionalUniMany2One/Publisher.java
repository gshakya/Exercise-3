package com.gunjan.model.optionalUniMany2One;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {

	@GeneratedValue @Id
	private int id;	
	private String name;
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
