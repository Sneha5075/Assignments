package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@SequenceGenerator(name="student_sequence",
			sequenceName="student_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator="student_sequence")
	private long id;
	private String name;
	private String email;
	private LocalDate dob;
	
	@Transient
	private Integer age;
	private LocalDate doj;
	private boolean deleted = Boolean.FALSE;
	
	
	public Student( String name, String email, LocalDate dob,LocalDate doj) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.doj=doj;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}




	
	

}
