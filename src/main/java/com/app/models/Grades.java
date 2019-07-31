package com.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="grades")
public class Grades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gid;
	
	private String studentgrade;
	

	public Grades() {}

	public Grades(String studentgrade) {
		super();
		this.studentgrade = studentgrade;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getStudentgrade() {
		return studentgrade;
	}

	public void setStudentgrade(String studentgrade) {
		this.studentgrade = studentgrade;
	}

	@Override
	public String toString() {
		return studentgrade;
	}


	
	
	
	
	
}
