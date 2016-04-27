package com.gunjan.model.one2Many;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private long employeeNumber;
	
	private String name;
	
	@ManyToOne
	@JoinColumn (name = "Department_id")
	private Department department;

//	public long getEmployeeNumber() {
//		return employeeNumber;
//	}
//
	// public void setEmployeeNumber(long employeeNumber) {
	// this.employeeNumber = employeeNumber;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
		department.addEmployees(this);
	}

}
