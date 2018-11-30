package com.bedbugs.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bedbugs.springdemo.dao.StudentDAO;
import com.bedbugs.springdemo.entity.Student;
import com.bedbugs.springdemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// need to inject the customer dao
@Autowired
private StudentService studentService;
	
@GetMapping("/home")
public String home(Model theModel) {
	
	
	return"home";
}
	


@GetMapping("/student-home")
public String studenthome(Model theModel) {
	
	
	return"student-home";
}


@GetMapping("/admin-home")
public String adminhome(Model theModel) {
	
	
	// get customers from the service
	
	List<Student> theStudents = studentService.getStudentspend();
	
	//add the customers to the model

	theModel.addAttribute("students", theStudents);
	return"admin-home";
}
	

@GetMapping("/admin-all")
public String adminall(Model theModel) {
	
	
	// get customers from the service
	
	List<Student> theStudents = studentService.getStudentsall();
	
	//add the customers to the model

	theModel.addAttribute("students", theStudents);
	return"admin-all";
}
	

	

	
@GetMapping("/list")
public String listStudent(Model theModel) {
	
	
	// get customers from the service
	
	
	List<Student> theStudents = studentService.getStudents();
	
	//add the customers to the model

	theModel.addAttribute("students", theStudents);
	
	
	return "list-students";
}

@GetMapping("/appstatus")
public String appstatus(Model theModel) {



	// get customers from the service
	
	
	List<Student> theStudents = studentService.getStudents();
	
	//add the customers to the model

	theModel.addAttribute("students", theStudents);
	
	return "app-status";
	
}


@GetMapping("/students-form")
public String showFormForAdd(Model theModel)
{
	
	Student theStudent = new Student();
	
	theModel.addAttribute("student", theStudent);
	
	

	return "/students-form";
	
}
	


@PostMapping("/saveStudent")
public String saveStudent(@ModelAttribute("student") Student theStudent)
{

	studentService.saveStudent(theStudent);
	
	return "redirect:/student/appstatus";
	
}

@GetMapping ("/showFormForUpdate")
public String showForForUpdate(@RequestParam("studentId")int theId, Model theModel) {
	
	//get the student from the db
	
	Student theStudent = studentService.getStudent(theId);
	
	
	// set the student as a model attribute
	
	theModel.addAttribute("student",theStudent);
	
	
	// send to form
	
	return "students-form";
}
	

@GetMapping("/reject")
public String rejectStudent(@RequestParam("studentId")int theId) {
	
	//delete the student
	
	studentService.rejectStudent(theId);
	
	return "redirect:/student/admin-home";
	
	
	
}


@GetMapping("/approve")
public String approveStudent(@RequestParam("studentId")int theId) {
	
	//delete the student
	
	studentService.approveStudent(theId);
	
	return "redirect:/student/admin-home";
	
	
	
}

@GetMapping("/delete")
public String deleteStudent(@RequestParam("studentId")int theId) {
	
	//delete the student
	
	studentService.deleteStudent(theId);
	
	return "redirect:/student/list";
	
	
	
}


}
