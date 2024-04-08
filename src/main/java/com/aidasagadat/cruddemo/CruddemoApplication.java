package com.aidasagadat.cruddemo;

import com.aidasagadat.cruddemo.dao.StudentDAO;
import com.aidasagadat.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			deleteALl(studentDAO);
		};
	}

	private void deleteALl(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted: " + numRowsDeleted);
	}


	private void deleteStudent(StudentDAO studentDAO) {
		Integer id = 7;
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Integer id = 1;
		Student student = studentDAO.findById(id);
		student.setLastName("Timurid");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void queryForStudentsByLastname(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findBylastName("Sagadat");
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Yerkezhan", "Yerkasymova", "yayorcha@gmail.com");
		studentDAO.save(student);
		int theId = student.getId();
		Student foundStudent = studentDAO.findById(theId);
		System.out.println(foundStudent);
	}


	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Hamza", "Sagadat", "hamzeke@gmail.com");
		studentDAO.save(student);
	}

}































