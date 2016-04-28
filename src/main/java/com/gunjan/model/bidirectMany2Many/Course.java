package com.gunjan.model.bidirectMany2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@GeneratedValue @Id
	private long id;
	
	private int courseNumber;
	
	private String name;
	
	@ManyToMany (cascade = {CascadeType.PERSIST})
	@JoinTable(name = "student_course_rel", 
			   joinColumns = @JoinColumn(name= "COURSE_ID") , 
			   inverseJoinColumns = @JoinColumn(name= "sTUDENT_id"))
	private Set<Student> students = new HashSet<Student>();

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addStudentOnly(Student s){
		students.add(s);
	}
	
	public void addStudent (Student s){
		students.add(s);
		s.addCourseOnly(this);
	}

}
