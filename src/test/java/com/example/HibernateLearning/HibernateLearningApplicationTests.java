package com.example.HibernateLearning;

import com.example.HibernateLearning.Entity.Student;
import com.example.HibernateLearning.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HibernateLearningApplicationTests{

	StudentService service = new StudentService();
	@Test
	public void getStudentTest(){
		Student student = service.getbyId(2);
		System.out.println(student.getName());
		List<Student> name = service.getStudentsOfSameCollege("IITK");
		System.out.println(name.size());

	}


	void contextLoads() {
	}

}
