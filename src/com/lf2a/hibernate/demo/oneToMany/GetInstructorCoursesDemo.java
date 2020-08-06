package com.lf2a.hibernate.demo.oneToMany;

import com.lf2a.hibernate.demo.oneToMany.entity.Course;
import com.lf2a.hibernate.demo.oneToMany.entity.Instructor;
import com.lf2a.hibernate.demo.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println(instructor);

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
