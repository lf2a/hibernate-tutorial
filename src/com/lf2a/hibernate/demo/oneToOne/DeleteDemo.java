package com.lf2a.hibernate.demo.oneToOne;

import com.lf2a.hibernate.demo.oneToOne.entity.Instructor;
import com.lf2a.hibernate.demo.oneToOne.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println(instructor.toString());

            if (instructor != null) {
                session.delete(instructor);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
