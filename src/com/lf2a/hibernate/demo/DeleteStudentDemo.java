package com.lf2a.hibernate.demo;

import com.lf2a.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            session.delete(myStudent);

            session.createQuery("delete from Student s where s.id=:id")
                    .setParameter("id", 4)
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
