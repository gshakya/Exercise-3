package com.gunjan.model.one2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Department {
	@Id	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(mappedBy="department", cascade = {CascadeType.PERSIST})
	private List<Employee> employees = new ArrayList<>();
	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
		
	}
	
	public void addEmployees(Employee e){
		employees.add(e);
		if(e.getDepartment()==null){
			e.setDepartment(this);
		}
	}
	
	
}
