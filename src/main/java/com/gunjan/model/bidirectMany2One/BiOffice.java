package com.gunjan.model.bidirectMany2One;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class BiOffice {
	@Id
	@GeneratedValue
	private int id;
	
	private int roomNumber;
	
	private String building;
	
	@OneToMany(mappedBy= "office")
	private Set<BiEmployee> employees = new HashSet<BiEmployee>();

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}
	
	public void addEmployees(BiEmployee b){
		employees.add(b);
	}
}
