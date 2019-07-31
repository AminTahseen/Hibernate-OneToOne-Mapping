package com.app.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Grades;
import com.app.repository.GradesRepository;
import com.app.service.interfaces.GradeServices;

@Service
public class GradeServicesImpl implements GradeServices {

	@Autowired
	private GradesRepository repoGRADE;
	
	@Transactional
	@Override
	public List<Grades> GetAll() 
	{
		List<Grades> grades =(List<Grades>) repoGRADE.findAll();
		return grades;
	}

	@Transactional
	@Override
	public void DeleteGrades(int gid) 
	{
		Grades grade=repoGRADE.findById(gid).get();
		repoGRADE.delete(grade);
	}

	@Transactional
	@Override
	public Grades getGradeByID(int gid)
	{
		Grades grade = repoGRADE.findById(gid).get();
		return grade;
	}

	@Transactional
	@Override
	public void SaveGrades(Grades grade) 
	{
		repoGRADE.save(grade);
	}

	@Transactional
	@Override
	public void EditGrades(int gid, String grade) 
	{
		Grades up_grade=repoGRADE.findById(gid).get();
		up_grade.setStudentgrade(grade);
		repoGRADE.save(up_grade);
	}


}
