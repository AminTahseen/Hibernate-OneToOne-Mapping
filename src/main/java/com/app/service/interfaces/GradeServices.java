package com.app.service.interfaces;

import java.util.List;

import com.app.models.Grades;


public interface GradeServices 
{
	List<Grades> GetAll();
	
	void SaveGrades(Grades grade);
	
	void DeleteGrades(int gid);
	
	void EditGrades(int gid,String grade);
	
	Grades getGradeByID(int gid);
}
