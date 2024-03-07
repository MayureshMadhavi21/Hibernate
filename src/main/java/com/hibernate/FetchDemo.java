package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//get for fetching data
/*
 * get() of Hibernate Sessions return null if object is not found in cache as well as in database.
 * get() involves database hit if object doesn't exist in Session cache and returns a fully initialized object 
   which may involve several database call.
 * Use if unsure about object exist in db or not.
 * */
		Student student = (Student)session.get(Student.class,1);
		System.out.println(student);
		
		//load for fetching data
/*
 * load() throws ObjectNotFoundException if object is not found on cache as well as on database but never return null.
 * load() can return proxy in place and only initialize the object or hit the database if any method other than 
   getId() is called on persistent or entity  object.This lazy initialization increases performance.
 * use if sure that object exist.  
 * */
		Address address = (Address)session.load(Address.class,1);
		System.out.println(address);
		session.close();
		sessionFactory.close();

	}

}
