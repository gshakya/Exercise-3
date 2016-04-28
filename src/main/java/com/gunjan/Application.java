package com.gunjan;



import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gunjan.model.bidirectMany2Many.Course;
import com.gunjan.model.bidirectMany2Many.Student;
import com.gunjan.model.one2Many.Department;
import com.gunjan.model.one2Many.Employee;
import com.gunjan.model.optionalUniMany2One.Book;
import com.gunjan.model.optionalUniMany2One.Publisher;
import com.gunjan.model.uniDirectMany2One.UniBook;
import com.gunjan.model.uniDirectMany2One.UniCustomer;
import com.gunjan.model.uniDirectMany2One.UniReservation;
import com.gunjan.model.uniDirectOne2Many.Customer;
import com.gunjan.model.uniDirectOne2Many.Reservation;



public class Application {
	private static final SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		sessionFactory = configuration.configure().buildSessionFactory();
	}
	
	public static void main(String[] args) {
		//-----------One to Many--------
//		addDepartment();
//		printDepartment();
		//------------------------------
		
		//-------Many To One with optional------------
//		addBook();
		//------------------------------
		
		//--------Bidirectional Many to Many----------
//		addCourseNStd();
		
		//------Unidirectional OneToMany -------------
//		addCustNReserv();
		
		//------Unidirectional ManyToOne---------
		addCustReservBook();
		
	}

	private static void addCustReservBook() {		
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			
			UniCustomer c1 = new UniCustomer();
			c1.setName("Gunjan");
			
			UniCustomer c2 = new UniCustomer();
			c2.setName("Prabhat");
			
			UniReservation r1 = new UniReservation();
			r1.setDate(new Date());
			
			UniReservation r2 = new UniReservation();
			r2.setDate(new Date());
			
			UniReservation r3 = new UniReservation();
			r3.setDate(new Date());
			
			UniReservation r4 = new UniReservation();
			r4.setDate(new Date());
			
			UniBook b1 = new UniBook();
			b1.setTitle("Java");
			b1.setAuthor("Joshua");
			b1.setIsbn("JVA-1");
			
			
			UniBook b2 = new UniBook();
			b2.setTitle("OOP C++");
			b2.setAuthor("Balagurusamy");
			b2.setIsbn("OOP-C-1");
			
			tx = session.beginTransaction();
			
			c1.addReservation(r1);
			c1.addReservation(r2);
			
			c2.addReservation(r3);
			c2.addReservation(r4);
			
			r1.setBook(b1);
			r2.setBook(b2);
			r3.setBook(b1);
			r4.setBook(b2);
			
			session.persist(c1);
			session.persist(c2);
			tx.commit();
			
		}
		catch (HibernateException ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
		finally {
			if (session != null) session.close();
		}
		
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
		
	}

	private static void addCustNReserv() {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			
			Customer c1 = new Customer();
			c1.setName("Gunjan");
			
			Reservation r1 = new Reservation();
			r1.setDate(new Date());
			Reservation r2 = new Reservation();
			r2.setDate(new Date());
			
			c1.addReservation(r1);
			c1.addReservation(r2);
			
			
			tx = session.beginTransaction();
			
			session.persist(c1);
			tx.commit();
			
		}
		catch (HibernateException ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
		finally {
			if (session != null) session.close();
		}
		
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
		
	}

	private static void addCourseNStd() {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			
			Student s1 = new Student();
			s1.setFirstName("Gunjan");
			s1.setLastName("Shakya");
			
			Student s2 = new Student();
			s2.setFirstName("Madan");
			s2.setLastName("Siwakoti");
			
			Student s3 = new Student();
			s3.setFirstName("Micheal");
			s3.setLastName("Zhao");
			
			Student s4 = new Student();
			s4.setFirstName("Bimal");
			s4.setLastName("Sharma");
			
			Course c1 = new Course();
			c1.setCourseNumber(435);
			c1.setName("Algorithms");
			
			Course c2 = new Course();
			c2.setCourseNumber(431);
			c2.setName("WAP");
			
			Course c3 = new Course();
			c3.setCourseNumber(432);
			c3.setName("EA");
			
			Course c4 = new Course();
			c4.setCourseNumber(435);
			c4.setName("ASD");
			
			s1.addCourse(c1);
			s1.addCourse(c2);
			s1.addCourse(c3);
			
			c2.addStudent(s2);
			c2.addStudent(s3);
			c2.addStudent(s4);
			
			s3.addCourse(c1);
			s3.addCourse(c4);
						
			c4.addStudent(s4);
			c4.addStudent(s2);
			
			tx = session.beginTransaction();
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			session.persist(s4);
			tx.commit();
		}
		catch (HibernateException ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
		finally {
			if (session != null) session.close();
		}
		
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
		
	}

	private static void addBook() {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			Book b1 = new Book();
			Book b2 = new Book();
			
			Publisher p1 = new Publisher();
			
			b1.setAuthor("Dan Brown");
			b1.setIsbn("D-DV-CODE");
			b1.setTitle("The DaVinci Code");
			
			p1.setName("Amazon");
			
			b2.setAuthor("David Liss");
			b2.setIsbn("D-DVL-COMP");
			b2.setAuthor("David Liss");
			b2.setTitle("The Devil's Company");
			b2.setPublisher(p1);
			
					
			
			
			tx = session.beginTransaction();
			
			session.persist(b1);
			session.persist(b2);
			tx.commit();
		}
		catch (HibernateException ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
		finally {
			if (session != null) session.close();
		}
		
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
				
		
	}

	private static void printDepartment() {
		// TODO Auto-generated method stub
		
	}

	private static void addDepartment() {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			
			Department d = new Department();
			d.setName("Computer");
			Employee e1 = new Employee();
			e1.setName("Gunjan");
			e1.setDepartment(d);
			
			Employee e2 = new Employee();
			e2.setName("Bimal");
			e2.setDepartment(d);
			
			tx = session.beginTransaction();
			
			session.persist(d);
			tx.commit();
		}
		catch (HibernateException ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
		finally {
			if (session != null) session.close();
		}
		
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
				
	}
}
