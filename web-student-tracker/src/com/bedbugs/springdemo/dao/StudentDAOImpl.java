package com.bedbugs.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bedbugs.springdemo.entity.Student;
@Repository

public class StudentDAOImpl implements StudentDAO {
// need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		
		
// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
// create a query

		Query<Student> theQuery = currentSession.createQuery("from Student ORDER BY id DESC ", Student.class);
		
	     theQuery.setMaxResults(1);

//executing query and get result list
		
		List<Student> students = theQuery.getResultList();
		
		

// return the results		
		
		return students;
		
		
	}

	@Override
	public void saveStudent(Student theStudent) {
		// get the session hibernate
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStudent);
		
		
		// save the student into the database
		
		
		
		
	}

	@Override
	public Student getStudent(int theId) {
		// get the current hibernate session
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
	
	
		// retrive object from database
		Student theStudent = currentSession.get(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
	
	
		
		// use primary key to delete object
		
	Query theQuery=currentSession.createQuery("delete from Student where id=:studentId");
	
	theQuery.setParameter("studentId", theId);
		
	theQuery.executeUpdate();
	}

	@Override
	public List<Student> getStudentspend() {

		
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				
				
		// create a query

				Query<Student> theQuery = currentSession.createQuery("from Student S WHERE S.status ='pending'", Student.class);
				
		//executing query and get result list
				
				List<Student> students = theQuery.getResultList();
				
				

		// return the results		
				
				return students;
	}

	@Override
	public void rejectCustomer(int theId) {
		
	// get the current hibernate session
		
		String reject = "rejected";
		
		Session currentSession = sessionFactory.getCurrentSession();
		

		
		// use primary key to delete object
		
	Query theQuery=currentSession.createQuery("update Student set status = :reject"
			+ " where id = :studentId");
	
	
	theQuery.setParameter("studentId", theId);
	theQuery.setParameter("reject", reject);
	theQuery.executeUpdate();
		
		
		
	}

	@Override
	@Transactional
	public void approveCustomer(int theId) {

	// get the current hibernate session
		
		String approve = "approved";
		
		Session currentSession = sessionFactory.getCurrentSession();
		

		
		// use primary key to delete object
		
	Query theQuery=currentSession.createQuery("update Student set status = :approve"
			+ " where id = :studentId");
	
	
	theQuery.setParameter("studentId", theId);
	theQuery.setParameter("approve", approve);
	theQuery.executeUpdate();
	}

	@Override
	public List<Student> getStudentsall() {

		
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				
				
		// create a query

				Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
				
		//executing query and get result list
				
				List<Student> students = theQuery.getResultList();
				
				

		// return the results		
				
				return students;
	}

}



