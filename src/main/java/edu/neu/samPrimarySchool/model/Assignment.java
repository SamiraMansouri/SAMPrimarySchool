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
@Table(name = "Assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Assignment_ID")
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
	
	@Column(name = "Content")
	private String content;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Column(name = "Goal")
	private String goal;
	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Createtion_Date")
	private Date creationDate;
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Deadline")
	private Date deadline;
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	@Column(name = "Class_ID")
	private int classId;
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
	private Set<Attachment> attachment = new HashSet<Attachment>();
	public Set<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachment = attachment;
	}
	
	public Assignment()
	{
		
	}
	public Assignment( String subject, String content,String goal,Date creationDate, Date deadline, int classId, Teacher teacher) {
		this.subject=subject;
		this.content=content;
		this.goal=goal;
		this.creationDate=creationDate;
		this.deadline=deadline;
		this.classId=classId;
		this.teacher=teacher;
	}
	public Assignment(int id, String subject, String content,String goal, Date deadline) {
		this.id=id;
		this.subject=subject;
		this.content=content;
		this.goal=goal;
		this.deadline=deadline;
	}

	



}
