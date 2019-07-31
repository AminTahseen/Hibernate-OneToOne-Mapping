package com.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	private String sname;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "gradeid")
	private Grades grade;

	public Student() {}
	

	public Student(String sname, Grades grade) {
		super();
		this.sname = sname;
		this.grade = grade;
	}

	public Student(int sid, String sname, Grades grade) {
		super();
		this.sname = sname;
		this.grade = grade;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [sname =" + sname + ", grade=" + grade + "]";
	}
	
	
}
