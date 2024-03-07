package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.mapping.Project;

public class SQLExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String query = "Select * from project";
		NativeQuery nativeQuery = session.createSQLQuery(query);
		List<Object[]> list = nativeQuery.getResultList();   //or .list()
		for(Object[] project : list) {
			   System.out.println(Arrays.toString(project));
		   };
		session.close();
	    sessionFactory.close();
	}

}
