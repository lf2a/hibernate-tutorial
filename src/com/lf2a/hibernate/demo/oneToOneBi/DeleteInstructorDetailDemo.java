package com.lf2a.hibernate.demo.oneToOneBi;

import com.lf2a.hibernate.demo.oneToOneBi.entity.Instructor;
import com.lf2a.hibernate.demo.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);

            System.out.println(instructorDetail.toString());

            // para apagar somente o instructoDetail deve apagar o link bidirecional
            // ou seja em instructor o instructor_detail_id deve ser null
            // apagando o insstructorDetail e o instructor associado a ele
            session.delete(instructorDetail);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
