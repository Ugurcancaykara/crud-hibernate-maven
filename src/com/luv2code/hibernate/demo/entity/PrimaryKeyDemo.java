package com.luv2code.hibernate.demo.entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PrimaryKeyDemo {

    public static void main(String[] args){

            SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

            Session session = factory.getCurrentSession();


            try{

                //If we want to create multiple objects with unique primary key
                //we need to use @GeneratedValue(strategy = GenerationType.IDENTITY) like we did at Student.java
                //Otherwise it will display an error
                System.out.println("Create 3 student objects ...");
                Student tempStudent1 = new Student("Freak","Out","freakout@luv2code.com");
                Student tempStudent2 = new Student("LeBron","James","lebronjames@luv2code.com");
                Student tempStudent3 = new Student("Kobe","Bryant","kobebryant@luv2code.com");


                //start a transaction
                session.beginTransaction();


                //save the student object
                session.save(tempStudent1);
                session.save(tempStudent2);
                session.save(tempStudent3);
                //save the student object

                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done!");
            }
            finally {
                session.close();
            }

    }

}
