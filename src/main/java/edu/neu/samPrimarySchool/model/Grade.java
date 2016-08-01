package edu.neu.samPrimarySchool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student_Grade_ID")
	private int gradeId;
	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
	
	@Column(name="Value")
	private String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Column(name="Description")
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="Grade_List_ID")
	private GradeList gradeList=new GradeList();
	public GradeList getGradeList() {
		return gradeList;
	}

	public void setGradeList(GradeList gradeList) {
		this.gradeList = gradeList;
	}


	@ManyToOne
	@JoinColumn(name = "Student_ID")
	private Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
