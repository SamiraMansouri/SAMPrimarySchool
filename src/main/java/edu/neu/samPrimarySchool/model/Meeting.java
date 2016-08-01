package edu.neu.samPrimarySchool.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Meeting")
public class Meeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Meeting_Id")
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="Meeting_Date")
	private Date meetingDate;
	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name="Meeting_Time_To")
	private Date timeTo;
	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name="Meeting_Time_From")
	private Date timeFrom;
	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	
	@Column(name="Subject")
	private String subject;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@ManyToOne
	@JoinColumn(name="Asker_ID")
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Participant", joinColumns = { 
			@JoinColumn(name = "Meeting_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", 
					nullable = false, updatable = false) })
	private Set<User> participant=new HashSet<User>();
	public Set<User> getParticipant() {
		return participant;
	}

	public void setParticipant(Set<User> participant) {
		this.participant = participant;
	}
	
	
	
}
