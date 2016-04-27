package com.gunjan;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.gunjan.model.one2Many.Department;
import com.gunjan.model.one2Many.Employee;
import com.gunjan.model.optionalUniMany2One.Book;
import com.gunjan.model.optionalUniMany2One.Publisher;



public class Application {
	private static final SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		sessionFactory = configuration.configure().buildSessionFactory();
	}
	
	public static void main(String[] args) {
		//-----------One to Many--------
		addDepartment();
		printDepartment();
		//------------------------------
		addBook();
		//-------Many To One------------
		
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
