package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args){

        //These are the basic steps for making use to queries.
        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")//hibernate config file
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = factory.getCurrentSession();// we create session with Session class from factory object
        // for database transactions

        try {
            //DELETE CODE
            int studentId = 2;
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            System.out.println("\nGetting student with id "+studentId);
//
//
//            //retrieve student based on the id: primary key
//            Student myStudent = session.get(Student.class,studentId);
//
//            //delete the student
//            System.out.println("Deleting student: "+myStudent);
//            session.delete(myStudent);
//
//
//
//            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();

            int studentIds = 3 ;
            session.createQuery("delete from Student where id="+studentIds).executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");

            //DELETE CODE - End
        }
        finally {
            factory.close();
        }
    }
}
