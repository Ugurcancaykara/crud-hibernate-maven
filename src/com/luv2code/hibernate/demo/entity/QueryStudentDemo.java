package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args){

        //Same steps with other main classes (ReadStudentDemo etc.) actual thing is in try block
        //create SessionFactory object to use create a session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();//now we can use session for queries

        try {


            session.beginTransaction();
            //For queries we use HQL (Hibernate Query Language)

            //Query All Students
            List<Student> theStudents = session.createQuery("from Student").getResultList();//Select all data.

            //display the students

            displayStudents(theStudents); //Display it with a for loop.
            //Query All Students

            System.out.println("\n\n");

            //query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName = 'James'").getResultList();
            //select data where student.lastName = James

            //display lastname
            displayStudents(theStudents); //Dispaly it with a for loop.
            System.out.println("Students who have last name of James");



            //query students: lastName ='Duck' OR firstName = 'Kobe'
            theStudents = session.createQuery("from Student s where s.lastName='Duck' OR " +
                    " s.firstName='Kobe'").getResultList();
            System.out.println("\n\nStudents who have last name of Duck OR first name = Kobe");
            displayStudents(theStudents);
            //query students: lastName ='Duck' OR firstName = 'Kobe'


            //query students: LIKE usage

            theStudents = session.createQuery("from Student s where s.email LIKE '@luv2code.com'").getResultList();
            displayStudents(theStudents);
            System.out.println("LIKE QUERY RESULT OF STUDENT");
            //query students: LIKE usage

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
