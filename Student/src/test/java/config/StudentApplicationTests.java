package config;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Model.Student;
import Service.Student_Service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {

	@Autowired
	private Student_Service studentservice;

	@Test
	public void testGetStudentList() {
		assertFalse(studentservice.getStudents().isEmpty());
	}
	
	@Test
	public void testGetStudentById() {
		Student testStudent = new Student();
		testStudent.setStudent_id(1);
		assertNotNull(studentservice.getStudentByID(testStudent));
	}
	
	@Test
	public void testSaveStudent() {
		// save test student
		Student testStudent = new Student();
		String name = "TEST_"+randomAlphabetic(8);
		testStudent.setStudent_name(name);
		testStudent.setStudent_email(name+"@gmail.com");
		testStudent.setStudent_branch("IT");
		// verify save is success
		assertTrue(studentservice.saveStudent(testStudent));
	}
	
	@Test
	public void testUpdateStudent() {
		// save test student
		Student testStudent = new Student();
		String name = "TEST_"+randomAlphabetic(8);
		testStudent.setStudent_name(name);
		testStudent.setStudent_email(name+"@gmail.com");
		testStudent.setStudent_branch("IT");
		studentservice.saveStudent(testStudent);
		// update test student
		List<Student> students = studentservice.getStudents();
		Student updStudent = students.get(students.size()-1);
		updStudent.setStudent_branch("CSE");
		// verify update is success
		assertTrue(studentservice.updateStudent(updStudent));
	}
	
	@Test
	public void testDeleteStudent() {
		// save test student
		Student testStudent = new Student();
		String name = "TEST_"+randomAlphabetic(8);
		testStudent.setStudent_name(name);
		testStudent.setStudent_email(name+"@gmail.com");
		testStudent.setStudent_branch("IT");
		studentservice.saveStudent(testStudent);
		// delete test student
		List<Student> students = studentservice.getStudents();
		Student delStudent = students.get(students.size()-1);
		// verify delete is success
		assertTrue(studentservice.deleteStudent(delStudent));
	}

}
