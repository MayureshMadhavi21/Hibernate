package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("HIbernate project started");
        /*
        new SessionFactory() cannot be written as it is an Interface
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.buildSessionFactory();
        above 3 lines written in single line below to get object of SessionFactoryImpl
        * */
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
      //creating student obj
        Student student = new Student();
        student.setStudentName("Mayuresh");
        student.setStudentCity("Mumbai");
        System.out.println(student);
        
        //creating address obj
        Address address = new Address();
        address.setPincode(400708);
        address.setCity("Navi Mumbai");
        address.setUrban(true);
        address.setX(12.23);
        address.setAddedDate(new Date());
        //adding image in address
        FileInputStream  image = new FileInputStream("src/main/java/hibernate2.png");
        byte[] imageByte = new byte[image.available()];
        image.read(imageByte);
        address.setImage(imageByte);
        System.out.println(address);
        image.close();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //session.save(student);
        session.save(address);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("Done.....");
    }
}
