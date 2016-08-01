package edu.neu.samPrimarySchool.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Student")
@PrimaryKeyJoinColumn(name = "User_ID")
public class Student extends User {

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_OF_Birth")
	private Date dateofBirth;

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@ManyToOne
	@JoinColumn(name = "Class_ID")
	private Classroom classroom;

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private Set<Grade> grades= new HashSet<Grade>();
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@ManyToOne
	@JoinColumn(name="Parent_ID")
	private Parent parent;

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
}
