package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class MappingDemoMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
        Question question1 = new Question();
		question1.setQuestionId(123);
		question1.setQuestion("What is java?");
		
		Question question2 = new Question();
		question1.setQuestionId(177);
		question1.setQuestion("What is collection framework?");
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(2313);
		answer1.setAnswer("programming language");
		question1.setAnswer(answer1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(564);
		answer2.setAnswer("API");
		question2.setAnswer(answer2);
		
		session.save(question1);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
/*
 Fetch Type
 1)Lazy - In lazy loading, associated data loads only when we explicitly call getter or setter method.
 
 2)Eager - It is a design pattern in which data loading occurs on the spot.
 
 ***Hibernate/Persistence lifecycle states***
 
 1)Transient state - when new object is created and its properties are set.Not associated with session yet.
 
 2)Persistent state - when session.save(obj) or persist() or saveUpdate() is call , obj is now associated with session and database and Saved in database.In this  
                      state if value of any property of object is changes same is reflected in database due to association with both. 
 
 3)Detached state - when session.close() or clear() is called object is detached from session.
                    session.update() get object to persitent state again.
 
 4)Removed State - object in persistent state , session.delete() is called, value removed from database, but associated with session.
 * */
