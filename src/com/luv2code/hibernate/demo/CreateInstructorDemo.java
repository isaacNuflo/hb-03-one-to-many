package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			/*Instructor tempInstructor = new Instructor("Isaac", "Ñuflo", "isaac.nuflo@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/manuply", "love to run");*/
			
			Instructor tempInstructor = new Instructor("Ana", "Gamarra", "ana.gamarra@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/charlie", "love to eat");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println(tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
