package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args){

        //These are the basic steps for making use to queries.
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//our hibernate config file
                .addAnnotatedClass(Student.class)//class we want to use
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Lets create and object then read it from db.


            // use the session object to save Java object
            //create a student object
            //CREATE CODE
            System.out.println("Creating new student object ...");
            Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");


            //start a transaction
            session.beginTransaction();


            System.out.println(tempStudent);
            //save the student object
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();
            //CREATE CODE

            // Read Code
            System.out.println("Saved student. Generated id: "+tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on the id: primary key

            System.out.println("\nGetting student with id : "+tempStudent.getId());
            Student myReadStudent = session.get(Student.class,tempStudent.getId());

            System.out.println("Get complete: "+myReadStudent);
            // Read Code


            //commit
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
