package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateStates {

	public static void main(String[] args) {
	   
		/* Hibernate States
		 * Transient 
		 * Persistent
		 * Detached
		 * Removed
		 * */
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("Mayuresh");
		student.setStudentCity("Mumbai");
		student.setCertificate(new Certificate("Hibrnate","2 Weeks")); //transient
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(student); //persistent
		transaction.commit();
		session.close();//detached
		sessionFactory.close();
		
	}

}
