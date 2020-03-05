package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Instructor tempInstructor = session.get(Instructor.class, 1);

			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				//CASCADE
				session.delete(tempInstructor);
			}

			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
