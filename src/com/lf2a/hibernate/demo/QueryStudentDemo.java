package com.lf2a.hibernate.demo;

import com.lf2a.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // criando session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // criando session
        Session session = factory.getCurrentSession();

        try {
            // iniciando uma transação
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display students
            // displayStudents(theStudents);

            // theStudents = session.createQuery("from Student s where s.firstName='Ana'").getResultList();
            // displayStudents(theStudents);

            // theStudents = session.createQuery("from Student s where s.lastName='filipy' or s.firstName='Ana'").getResultList();
            // displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email like '%email.com'").getResultList();
            displayStudents(theStudents);

            // comitando a transação
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    public static void displayStudents(List<Student> temp) {
        for (Student tempStudent : temp) {
            System.out.println(tempStudent);
        }
    }
}
