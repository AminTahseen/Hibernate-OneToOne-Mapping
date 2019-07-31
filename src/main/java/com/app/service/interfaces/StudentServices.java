package com.app.service.interfaces;

import java.util.List;

import com.app.models.Student;

public interface StudentServices {
	
	List<Student> GetAll();
	
	void SaveStudent(Student std);
	
	void DeleteStudent(int sid);
	
	void EditStudent(int sid,String sname,String sgrade);
	
	Student getStudentByID(int sid);
}
