package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.models.Grades;

public interface GradesRepository extends CrudRepository<Grades, Integer> 
{
	
}
