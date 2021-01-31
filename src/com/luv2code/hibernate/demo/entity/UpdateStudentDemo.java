package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args){

        //These are the basic steps for making use to queries.
        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")//hibernate config file
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = factory.getCurrentSession();// we create session with Session class from factory object
        // for database transactions

        try {
            //UPDATE CODE
            //Basic processes for doing an specific update Ex.

            int studentId = 1;

            //now let's start transaction
            session.beginTransaction();
            System.out.println("\n Getting student with id: "+studentId);
            Student myStudent = session.get(Student.class,studentId);
            System.out.println("\n Updating student : "+myStudent);
            myStudent.setFirstName("Scooby");
            System.out.println("\n myStudent updated: "+myStudent);


            //there is no need to explicitly say save or update just simply commit the transaction
            session.getTransaction().commit();

            //UPDATE CODE

            //ANOTHER UPDATE CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            //ANOTHER UPDATE CODE - END
        }
        finally {
            factory.close();
        }
    }
}
