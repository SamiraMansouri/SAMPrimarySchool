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
@Table(name = "Attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Attendance_ID")
	private int id;

	@org.hibernate.annotations.Type(type = "true_false")
	@Column(name = "Present")
	private boolean present;

	@ManyToOne
	@JoinColumn(name = "Student_ID")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "Attendance_List_ID")
	AttendanceList attendanceList;

	public AttendanceList getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(AttendanceList attendanceList) {
		this.attendanceList = attendanceList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

}
