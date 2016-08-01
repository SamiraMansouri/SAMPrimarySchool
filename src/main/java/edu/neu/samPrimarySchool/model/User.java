package edu.neu.samPrimarySchool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	public User() {
    }  
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true,nullable=false)
	
	private int iD;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	
	@Column(name="UserName")
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="Password")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="First_Name", nullable=true)
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="Last_Name", nullable=true)
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="Email",nullable=true)
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="Phone_Number",nullable=true)
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="Cell_Phone_Number")
	private String cellPhoneNumber;
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	
	@Column(name="address",nullable=true)
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="Role",nullable=true)
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private Set<Meeting> meeting= new HashSet<Meeting>();
	
	public Set<Meeting> getMeeting() {
		return meeting;
	}
	public void setMeeting(Set<Meeting> meeting) {
		this.meeting = meeting;
	}
	
	@OneToMany(mappedBy="receiver",cascade=CascadeType.ALL)
	private Set<Message> receiveMessage= new HashSet<Message>();
	
	public Set<Message> getReceiveMessage() {
		return receiveMessage;
	}
	public void setReceiveMessage(Set<Message> message) {
		this.receiveMessage = message;
	}
	
	@OneToMany(mappedBy="sender",cascade=CascadeType.ALL)
	private Set<Message> sentMessage= new HashSet<Message>();

	public Set<Message> getSentMessage() {
		return sentMessage;
	}
	public void setSentMessage(Set<Message> sentMessage) {
		this.sentMessage = sentMessage;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "participant")
	private Set<Meeting> participate_meeting= new HashSet<Meeting>();
	
	public Set<Meeting> getParticipant() {
		return participate_meeting;
	}
	public void setParticipant(Set<Meeting> participant) {
		this.participate_meeting = participant;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Announcement> announcement= new HashSet<Announcement>();
	
	public Set<Announcement> getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Set<Announcement> announcement) {
		this.announcement = announcement;
	}
	




	
	
}
