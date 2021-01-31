package com.luv2code.hibernate.demo.entity;


//This is our data object for table on db server(I use MySQL for this example)

import javax.persistence.*;



@Entity//This section determines that we want to associate this class to a table
@Table(name = "student")//and table name
public class Student {

    @Id//This annotation defines primary key (PK) for this class
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is one of the generation strategies to generate a PK
    //Specifies how to generate values for the given column.
    @Column(name = "id")//Column name
    private int id;

    @Column(name = "first_name")//Column name
    private String firstName;

    @Column(name = "last_name")//Column name
    private String lastName;

    @Column(name = "email")//Column name
    private String email;


    //constructors
    public Student(){

    }
    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //getter and setters must defined
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
