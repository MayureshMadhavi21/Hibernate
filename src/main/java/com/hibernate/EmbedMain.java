package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
        
		Student student = new Student();
        student.setStudentName("Kiran yadav");
        student.setStudentCity("Mumbai");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("5 months");
		student.setCertificate(certificate);
		
		Student student1 = new Student();
        student1.setStudentName("Prakash kachare");
        student1.setStudentCity("Mumbai");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("2 months");
		student1.setCertificate(certificate1);
		
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        session.save(student1);
        
        transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
