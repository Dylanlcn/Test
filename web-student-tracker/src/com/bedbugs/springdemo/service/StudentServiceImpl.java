
package com.bedbugs.springdemo.service;

import java.util.List;

import com.bedbugs.springdemo.dao.StudentDAO;
import com.bedbugs.springdemo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class StudentServiceImpl implements StudentService {

	
	@Autowired

	private StudentDAO studentDAO;
	
	
	@Override
	@Transactional
	public List <Student> getStudents(){
	
		return studentDAO.getStudents();
	
	}


	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		
		studentDAO.saveStudent(theStudent);
		
		
		
	}


	@Override
	@Transactional
	public Student getStudent(int theId) {
		// TODO Auto-generated method stub
		
		
		return studentDAO.getStudent(theId);
	}


	@Override
	@Transactional
	public void deleteStudent(int theId) {
		
		studentDAO.deleteCustomer(theId);
		
		
	}


	@Override
	@Transactional
	public List<Student> getStudentspend() {
		return studentDAO.getStudentspend();
		
	}


	@Override
	@Transactional
	public void rejectStudent(int theId) {
		
		studentDAO.rejectCustomer(theId);
		
		
	}


	@Override
	@Transactional
	public void approveStudent(int theId) {
	

		studentDAO.approveCustomer(theId);
		
	}


	@Override
	@Transactional
	public List<Student> getStudentsall() {
		
		return studentDAO.getStudentsall();
	}
	

}

