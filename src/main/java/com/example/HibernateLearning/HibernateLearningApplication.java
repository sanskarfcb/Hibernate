package com.example.HibernateLearning;

import com.example.HibernateLearning.Entity.Student;
import com.example.HibernateLearning.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateLearningApplication.class, args);

		Student student = new Student();

		student.setName("Anl");
		student.setAbout("Good in studies and is very lazy");
		student.setActive(true);
		student.setCollege_name("AKTU");
		student.setFathername("Anil Kumar");
		student.setPhone("1234529");


		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		System.out.println(sessionFactory);
//		System.out.println("okkk");

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			Transaction transaction1 = session.beginTransaction();
			session.persist(student);
			transaction1.commit();
			System.out.println("Student saved successfully");

		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
