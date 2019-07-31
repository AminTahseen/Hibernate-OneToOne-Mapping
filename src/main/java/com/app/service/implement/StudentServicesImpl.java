package com.app.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Grades;
import com.app.models.Student;
import com.app.repository.StudentRepository;
import com.app.service.interfaces.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	private StudentRepository repoSTD;
	
	@Transactional
	@Override
	public List<Student> GetAll() 
	{
		List<Student> List=(java.util.List<Student>) repoSTD.findAll();
		return List;
	}

	@Transactional
	@Override
	public void SaveStudent(Student std) 
	{
		repoSTD.save(std);
	}

	@Transactional
	@Override
	public void DeleteStudent(int sid) 
	{
		Student std=repoSTD.findById(sid).get();
		repoSTD.delete(std);
	}

	@Transactional
	@Override
	public Student getStudentByID(int sid) 
	{
		Student std=repoSTD.findById(sid).get();
		return std;
	}

	@Transactional
	@Override
	public void EditStudent(int sid, String sname, String sgrade) 
	{
		Student std=repoSTD.findById(sid).get();
		std.setSname(sname);
		std.setGrade(new Grades(sgrade));
		repoSTD.save(std);
	}
	
	

}
