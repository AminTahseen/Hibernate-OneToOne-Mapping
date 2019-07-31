package com.app.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.Grades;
import com.app.models.Student;
import com.app.repository.GradesRepository;
import com.app.service.interfaces.StudentServices;

@Controller
public class StudentGradeController {
	
	@Autowired
	private StudentServices SERVICE_STD;

	private static final Logger LOGGER = Logger.getLogger("StudentGradeController");

	@RequestMapping("/")
	public String Default(Model map) 
	{
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE DEFAULT '/' ----");
		
		try 
		{
			LOGGER.log(Level.INFO, "Fetching List...");
			
			List<Student> List=SERVICE_STD.GetAll();

			LOGGER.log(Level.INFO, "List Fetched, Passing it to Model 'Map'.. ");
			
			map.addAttribute("list", List);
			
			LOGGER.log(Level.INFO, "Successfully Transfered To Home.jsp !");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");
		
		return "home.jsp";
	}
	
	@GetMapping("/list")
	public String Home(Model map) 
	{
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /LIST ----");

		try 
		{

			LOGGER.log(Level.INFO, "Fetching List...");
		
			List<Student> List=SERVICE_STD.GetAll();

			LOGGER.log(Level.INFO, "List Fetched, Passing it to Model 'Map'.. ");
			
			map.addAttribute("list", List);
			
			LOGGER.log(Level.INFO, "Successfully Transfered To Home.jsp !");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");
		
		return "home.jsp";
	}
	
	@RequestMapping("/create")
	public String Create() 
	{
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /CREATE ----");
	
		try 
		{
			LOGGER.log(Level.INFO, "Page 'create.jsp' Successfully Displayed ! ");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");

		return "create.jsp";
	}
	
	@PostMapping("/save")
	public String Save(
			@RequestParam("sname") String sname,
			@RequestParam("sgrade") String grade,
			Model map
			          ) 
	{
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /SAVE ----");
		
		try 
		{
			LOGGER.log(Level.INFO, "Getting Requested Paramters...");
		
			Student std=new Student(sname, new Grades(grade));
			
			LOGGER.log(Level.INFO, "Parameters Fetched, Data['"+std.toString()+"']");
			
			LOGGER.log(Level.INFO, "Saving Data...");
			
			SERVICE_STD.SaveStudent(std);
			
			LOGGER.log(Level.INFO, "Data Saved !");

			LOGGER.log(Level.INFO, "Fetching List...");
			
			List<Student> List=SERVICE_STD.GetAll();

			LOGGER.log(Level.INFO, "List Fetched, Passing it to Model 'Map'.. ");
			
			map.addAttribute("list", List);
			
			LOGGER.log(Level.INFO, "Successfully Transfered To Home.jsp !");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");

		return "home.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id,Model map) 
	{	
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /EDIT ----");

		try 
		{
			LOGGER.log(Level.INFO, "Getting Requested Paramter 'id'...");
		
			LOGGER.log(Level.INFO, "Parameter Fetched !");
			
			LOGGER.log(Level.INFO, "Getting Student By Id '"+id+"'");
			
			Student std=SERVICE_STD.getStudentByID(id);
			
			LOGGER.log(Level.INFO, "Student Found ! Transferring To JSP Page");
			
			map.addAttribute("sid", std.getSid());
			
			map.addAttribute("sname", std.getSname());
			
			map.addAttribute("sgrade", std.getGrade());
			
			LOGGER.log(Level.INFO, "Student Data Successfully Transfered");
			
			LOGGER.log(Level.INFO, "Page 'edit.jsp' Successfully Displayed ! ");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");

		return "edit.jsp";
	}
	
	@PostMapping("/update")
	public String Update(
			@RequestParam("sid") int sid,
			@RequestParam("sname") String sname,
			@RequestParam("sgrade") String sgrade,
			Model map
			            ) 
	{

		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /UPDATE ----");
		
		try 
		{
			LOGGER.log(Level.INFO, "Getting Requested Paramters '[sid,sname,sgrade]'...");
			
			LOGGER.log(Level.INFO, "Parameters Fetched !");
			
			LOGGER.log(Level.INFO, "Parameters Values ["+sid+","+sname+","+sgrade+"]");

			LOGGER.log(Level.INFO, "Updating Student And Grade...");
			
			SERVICE_STD.EditStudent(sid,sname,sgrade);
			
			LOGGER.log(Level.INFO, "Student And Grade Updated !");
			
			LOGGER.log(Level.INFO, "Fetching List...");
			
			List<Student> List=SERVICE_STD.GetAll();

			LOGGER.log(Level.INFO, "List Fetched, Passing it to Model 'Map'.. ");
			
			map.addAttribute("list", List);
			
			LOGGER.log(Level.INFO, "Successfully Transfered To Home.jsp !");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");
		
		return "home.jsp";
	}
	
	@RequestMapping("/delete")
	public String Delete(
			@RequestParam("sid") int sid,
			Model map
			            )
	
	{
		LOGGER.log(Level.INFO, "   ");
		
		LOGGER.log(Level.INFO, "---- INSIDE /DELETE ----");
		
		try 
		{
			LOGGER.log(Level.INFO, "Getting Requested Paramter 'sid'...");
		
			LOGGER.log(Level.INFO, "Parameter Fetched !");
			
			LOGGER.log(Level.INFO, "Deleting Student With sid '"+sid+"'...");
			
			SERVICE_STD.DeleteStudent(sid);
			
			LOGGER.log(Level.INFO, "Student and Grade Deleted !");
			
			LOGGER.log(Level.INFO, "Fetching List...");
			
			List<Student> List=SERVICE_STD.GetAll();
		
			LOGGER.log(Level.INFO, "List Fetched, Passing it to Model 'Map'.. ");
			
			map.addAttribute("list", List);
			
			LOGGER.log(Level.INFO, "Successfully Transfered To Home.jsp !");
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.INFO, "An Exception Has Occured ["+e+"]");
		}
		
		LOGGER.log(Level.INFO, "---------------------");
		
		return "home.jsp";
	}
}
