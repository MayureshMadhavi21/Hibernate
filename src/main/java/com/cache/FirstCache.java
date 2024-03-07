package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstCache {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		//first level cache is bydefault enable and it is session level
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		Student student1 = session.get(Student.class, 1);
		System.out.println(student1);
		System.out.println(session.contains(student1));
		session.close();
	    sessionFactory.close();
	}

}
