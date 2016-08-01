package edu.neu.samPrimarySchool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Parent")
public class Parent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Parent_ID", nullable=true,unique=true)
	private int id;
	
	@Column(name="Mother_First_Name")
	private String mother_FirstName;
	
	@Column(name="Mother_Last_Name")
	private String mother_LastName;
	
	@Column(name="Father_First_Name")
	private String father_FirstName;
	
	@Column(name="Father_Last_Name")
	private String father_LastName;
	
	@Column(name="Mother_Education_Level")
	private String mother_EducationLevel;
	
	@Column(name="Father_Education_Level")
	private String father_EducationLevel;
	
	@Column(name="Mother_Major")
	private String mother_major;
	
	@Column(name="Father_Major")
	private String father_major;
	
	@Column(name="Mother_Job")
	private String mother_job;
	
	@Column(name="Father_Job")
	private String father_job;
	
	@Column(name="Mother_Job_Address")
	private String mother_jobAddress;
	
	@Column(name="Father_Job_Address")
	private String father_jobAddress;
	
	@Column(name="Mother_Phone_Number")
	private String mother_PhoneNumer;
	
	@Column(name="Father_Phone_Number")
	private String father_PhoneNumber;
	
	@Column(name="Mother_Email")
	private String mother_Email;
	
	@Column(name="Father_Email")
	private String father_Email;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL)
	private Set<Student> student =new HashSet<Student>();
	
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMother_FirstName() {
		return mother_FirstName;
	}

	public void setMother_FirstName(String mother_FirstName) {
		this.mother_FirstName = mother_FirstName;
	}

	public String getMother_LastName() {
		return mother_LastName;
	}

	public void setMother_LastName(String mother_LastName) {
		this.mother_LastName = mother_LastName;
	}

	public String getFather_FirstName() {
		return father_FirstName;
	}

	public void setFather_FirstName(String father_FirstName) {
		this.father_FirstName = father_FirstName;
	}

	public String getFather_LastName() {
		return father_LastName;
	}

	public void setFather_LastName(String father_LastName) {
		this.father_LastName = father_LastName;
	}

	public String getMother_EducationLevel() {
		return mother_EducationLevel;
	}

	public void setMother_EducationLevel(String mother_EducationLevel) {
		this.mother_EducationLevel = mother_EducationLevel;
	}

	public String getFather_EducationLevel() {
		return father_EducationLevel;
	}

	public void setFather_EducationLevel(String father_EducationLevel) {
		this.father_EducationLevel = father_EducationLevel;
	}

	public String getMother_major() {
		return mother_major;
	}

	public void setMother_major(String mother_major) {
		this.mother_major = mother_major;
	}

	public String getFather_major() {
		return father_major;
	}

	public void setFather_major(String father_major) {
		this.father_major = father_major;
	}

	public String getMother_job() {
		return mother_job;
	}

	public void setMother_job(String mother_job) {
		this.mother_job = mother_job;
	}

	public String getFather_job() {
		return father_job;
	}

	public void setFather_job(String father_job) {
		this.father_job = father_job;
	}

	public String getMother_jobAddress() {
		return mother_jobAddress;
	}

	public void setMother_jobAddress(String mother_jobAddress) {
		this.mother_jobAddress = mother_jobAddress;
	}

	public String getFather_jobAddress() {
		return father_jobAddress;
	}

	public void setFather_jobAddress(String father_jobAddress) {
		this.father_jobAddress = father_jobAddress;
	}

	public String getMother_PhoneNumer() {
		return mother_PhoneNumer;
	}

	public void setMother_PhoneNumer(String mother_PhoneNumer) {
		this.mother_PhoneNumer = mother_PhoneNumer;
	}

	public String getFather_PhoneNumber() {
		return father_PhoneNumber;
	}

	public void setFather_PhoneNumber(String father_PhoneNumber) {
		this.father_PhoneNumber = father_PhoneNumber;
	}

	public String getMother_Email() {
		return mother_Email;
	}

	public void setMother_Email(String mother_Email) {
		this.mother_Email = mother_Email;
	}

	public String getFather_Email() {
		return father_Email;
	}

	public void setFather_Email(String father_Email) {
		this.father_Email = father_Email;
	}	
	
}
