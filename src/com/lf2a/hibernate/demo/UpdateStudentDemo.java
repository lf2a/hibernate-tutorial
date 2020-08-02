package com.lf2a.hibernate.demo;

import com.lf2a.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // criando session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // criando session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 2;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update Student set email=:email")
                    .setParameter("email", "test@gmail.com")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
