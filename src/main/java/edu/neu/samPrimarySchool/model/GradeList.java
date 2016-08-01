package edu.neu.samPrimarySchool.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

/**
 * @author apple
 *
 */
@Entity
@Table(name = "Grade_List")
public class GradeList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Grade_List_ID")
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "Subject")
	private String subject;
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(name = "Scale")
	private String scale;
	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_of_Grade_List")
	private Date date;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "Class_ID")
	private int classId;
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	@Column(name="Description")
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Teacher_ID")
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "gradeList", cascade = CascadeType.ALL)
	private List<Grade> grade = new ArrayList<Grade>();
	public List<Grade> getGrade() {
		return grade;
	}

	public void setGrade(List<Grade> grade) {
		this.grade = grade;
	}

	public GradeList() {
		// TODO Auto-generated constructor stub
	}
	
	public GradeList(String subject,String description, String scale, Date date,int classdID,User user)
	{
		this.subject=subject;
		this.classId=classdID;
		this.date=date;
//		this.grade=grades;
		this.scale=scale;
		this.teacher=(Teacher)user;
		this.description=description;
	}
	
	public GradeList(int id,String subject,String description, String scale, Date date,int classdID,User user)
	{
		this.id=id;
		this.subject=subject;
		this.classId=classdID;
		this.date=date;
//		this.grade=grades;
		this.scale=scale;
		this.teacher=(Teacher)user;
		this.description=description;
	}

}
