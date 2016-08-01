package edu.neu.samPrimarySchool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Advisor")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Advisor extends User {
	
	@Column(name="major")
	private String Major;
	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}
	
	@Column(name="Education")
	private String Education;
	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_OF_Birth")
	private Date dateofBirth;
	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	
}
