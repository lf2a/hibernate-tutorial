package com.lf2a.hibernate.demo.oneToOneBi;

import com.lf2a.hibernate.demo.oneToOneBi.entity.Instructor;
import com.lf2a.hibernate.demo.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);

            System.out.println(instructorDetail.toString());
            System.out.println(instructorDetail.getInstructor().toString());

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
