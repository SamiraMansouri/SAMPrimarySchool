package edu.neu.samPrimarySchool.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
@Entity
@Table(name="Classroom")
public class Classroom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Class_ID")
	private int id;
	
	@Column(name="Class_Level")
	private String level;
	
	@Column(name="Class_Name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@OneToMany(mappedBy="classroom",cascade=CascadeType.ALL)
	private Set<Student> student=new HashSet<Student>();
	
	@OneToMany(mappedBy="classroom",cascade=CascadeType.ALL)
	private Set<Course> course=new HashSet<Course>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	
}
