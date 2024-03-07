package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class CascadeExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Question question =  new Question();
		question.setQuestion("What is cascading?");
		Answer answer1 = new Answer(1234,"first ans");
		Answer answer2 = new Answer(24,"second ans");
		Answer answer3 = new Answer(25,"third ans");
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(answer1);
		answers.add(answer2);
		answers.add(answer3);
		question.setAnswer(answer1);
		Transaction transaction = session.beginTransaction();
		session.save(question);
		transaction.commit();
		session.close();
	    sessionFactory.close();
	}

}
