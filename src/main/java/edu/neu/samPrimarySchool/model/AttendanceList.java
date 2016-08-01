package edu.neu.samPrimarySchool.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Attendance_List")
public class AttendanceList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Attendance_List_ID")
	private int id;

	@Column(name = "Subject")
	private String subject;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_of_Attendance_List")
	private Date date;

	@Column(name = "Class_ID")
	private int classId;

	@ManyToOne
	@JoinColumn(name = "Teacher_ID")
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "attendanceList", cascade = CascadeType.ALL)
	private Set<Attendance> attendance = new HashSet<Attendance>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public Set<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}

}
