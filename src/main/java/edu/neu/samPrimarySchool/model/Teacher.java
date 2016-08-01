package edu.neu.samPrimarySchool.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Teacher")
@PrimaryKeyJoinColumn(name="User_ID")
public class Teacher extends User {

	@Temporal(TemporalType.DATE)
	@Column(name="Date_of_Birth")
	private Date dateOfBirth;
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name="Educaion")
	private String Education;
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	
	@Column(name="Major")
	private String Major;
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	private Set<AttendanceList> attendanceList=new HashSet<AttendanceList>();
	public Set<AttendanceList> getAttendanceList() {
		return attendanceList;
	}
	public void setAttendanceList(Set<AttendanceList> attendanceList) {
		this.attendanceList = attendanceList;
	}
	
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	private Set<GradeList> gradeList=new HashSet<GradeList>();
	public Set<GradeList> getGradeList() {
		return gradeList;
	}
	public void setGradeList(Set<GradeList> gradeList) {
		this.gradeList = gradeList;
	}
	
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	private Set<Classroom> classroom=new HashSet<Classroom>();
	public Set<Classroom> getClassroom() {
		return classroom;
	}
	public void setClassroom(Set<Classroom> classroom) {
		this.classroom = classroom;
	}
		
}
