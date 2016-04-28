package com.gunjan.model.bidirectMany2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@GeneratedValue @Id
	private long studentId;
	private String firstName;
	private String lastName;
	
	@ManyToMany (cascade = {CascadeType.PERSIST} , mappedBy = "students")
	private Set<Course> courses = new HashSet<Course>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addCourseOnly(Course c){
		courses.add(c);
	}
	
	public void addCourse(Course c){
		courses.add(c);
		c.addStudentOnly(this);
	}

}
