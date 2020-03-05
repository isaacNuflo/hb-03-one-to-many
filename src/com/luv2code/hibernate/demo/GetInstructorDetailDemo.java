package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int theId = 2999;

			InstructorDetail tempinstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempinstructorDetail: " + tempinstructorDetail);
			
			System.out.println("Associated Instructor: " + tempinstructorDetail.getInstructor());

			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();//handle connection leak issue
			factory.close();
		}
	}

}
