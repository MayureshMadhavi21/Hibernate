package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mapping.Project;

public class HQLPagination {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Project");
		
		//implement pagination
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Project> list = query.list();
		 for(Project project : list) {
			   System.out.println(project);
		   };
		session.close();
	    sessionFactory.close();
	}
}
