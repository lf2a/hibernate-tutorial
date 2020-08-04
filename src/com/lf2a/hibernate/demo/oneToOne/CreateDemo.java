package com.lf2a.hibernate.demo.oneToOne;

import com.lf2a.hibernate.demo.entity.Student;
import com.lf2a.hibernate.demo.oneToOne.entity.Instructor;
import com.lf2a.hibernate.demo.oneToOne.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Pedro", "José", "pedro.jose@outlook.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "PedroJ");
            instructor.setInstructorDetail(instructorDetail);

            Instructor instructor2 = new Instructor("Ana", "Paula", "ana.paula@outlook.com");
            InstructorDetail instructorDetail2 = new InstructorDetail("http://youtube.com", "AnaP");
            instructor2.setInstructorDetail(instructorDetail2);


            session.beginTransaction();

            session.save(instructor);
            session.save(instructor2);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
