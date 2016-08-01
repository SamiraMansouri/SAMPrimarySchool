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
@Table(name="Message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Message_ID")
	private int id;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Content")
	private String content;
	
	@Column(name="Message_Time")
	private String time;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Message_Date")
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="Sender_ID")
	private User sender;
	 public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
	
	@ManyToOne
	@JoinColumn(name="Receiver_ID")
	private User receiver;
	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	

	@ManyToOne
	@JoinColumn(name="Reply_Message_ID")
	private Message Main_message;
	public Message getMessage() {
		return Main_message;
	}

	public void setMessage(Message message) {
		this.Main_message = message;
	}
	
	@OneToMany(mappedBy="Main_message",cascade=CascadeType.ALL)
	private Set<Message> replyMessage=new HashSet<Message>();

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Message> getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(Set<Message> replyMessage) {
		this.replyMessage = replyMessage;
	}
	
	
}
