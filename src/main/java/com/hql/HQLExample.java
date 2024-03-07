package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;


public class HQLExample {

	public static void main(String[] args) {
		
	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	   //HQL query
	   //select
	   String query = "from Student"; //entiy name
	   Session session = sessionFactory.openSession();
	   Query q = session.createQuery(query);
	   
	   //multiple - list =>  query.list()
	   //single - unique =>  query.uniqueResult()
	   List<Student> list = q.list();
	   for(Student student : list) {
		   System.out.println(student);
	   }
	   
	   String query1 = "from Student where studentCity='Mumbai'"; //varibale name
	   Query q1 = session.createQuery(query1);
	   List<Student> list1 = q1.list();
	   for(Student student : list1) {
		   System.out.println(student);
	   };
	   
	   String query2 = "from Student where studentCity=:x and studentName=:n"; //dynamic where
	   Query q2 = session.createQuery(query2);
	   q2.setParameter("x", "satara");
	   q2.setParameter("n", "saurabh");
	   List<Student> list2 = q2.list();
	   for(Student student : list2) {
		   System.out.println(student);
	   };
	   
	   //delete
//	   Query delete = session.createQuery("delete from Student s where s.studentCity=:c");
//	   delete.setParameter("c", "Navi Mumbai");
//	   Transaction transaction = session.beginTransaction();
//	   int r = delete.executeUpdate();
//	   transaction.commit();
//	   System.out.println("deleted rows "+r);	   
	   
	   //update
	   Query update = session.createQuery("update Student set studentCity=:c where studentId=:i");
	   update.setParameter("c", "south bombay");
	   update.setParameter("i", 3);
	   Transaction transaction = session.beginTransaction();
	   int r1 = update.executeUpdate();
	   transaction.commit();
	   System.out.println("updated rows "+r1);	   
	   
	   //join query
	   Query join = session.createQuery("select q.questionId , q.question , a.answer from Question as q INNER JOIN q.answer as a");
	   List<Object[]> list3 = join.list();
	   for(Object[] arr : list3) {
		   System.out.println(Arrays.toString(arr));
	   };
	   session.close();
       sessionFactory.close();
	}

}
