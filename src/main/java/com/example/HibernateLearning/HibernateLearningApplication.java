package com.example.HibernateLearning;

import com.example.HibernateLearning.Entity.Certificate;
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

		student.setName("Shivam Kumar");
		student.setAbout("Good in studies and is very lazy");
		student.setActive(true);
		student.setCollege_name("UPTU");
		student.setFathername("Sanskar Mishra");
		student.setPhone("12212332214529");

		Certificate certificate = new Certificate();
		certificate.setTitle("KPIT Certificate");
		certificate.setAbout("Certificate of exellence from kpit");
		certificate.setLink("jubucbdsdcscds");
		certificate.setStudent(student);

		Certificate certificate1 = new Certificate();
		certificate1.setTitle("Infosys Certificate");
		certificate1.setAbout("Certificate of exellence from Infosys");
		certificate1.setLink("jubucbdsedfsdcscds");
		certificate1.setStudent(student) ;

		student.getCertificates().add(certificate);
		student.getCertificates().add(certificate1);



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
