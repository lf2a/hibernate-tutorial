package com.lf2a.hibernate.demo;

import com.lf2a.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
// criando session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // criando session
        Session session = factory.getCurrentSession();

        try {
            Student tempStudent1 = new Student("Luiz", "Filipy", "luizfilipy@email.com");
            Student tempStudent2 = new Student("Ana", "Paula", "anapaula@email.com");
            Student tempStudent3 = new Student("Maria", "Souza", "mariasouza@email.com");

            session.beginTransaction();

            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
