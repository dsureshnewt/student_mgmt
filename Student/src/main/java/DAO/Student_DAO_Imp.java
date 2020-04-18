package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import Model.Student;

@Repository
public class Student_DAO_Imp  implements Student_DAO{

	private static List<Student> students = new ArrayList<Student>(Arrays.asList(
			new Student(1,"Selva","selva@newt.com","IT"),
			new Student(2,"Suresh","suresh@newt.com","IT"),
			new Student(3,"Arjun","arjun@newt.com","IT")
	));
	
	@Override
	public boolean saveStudent(Student student) {
		boolean status=false;
		try {
			student.setStudent_id(this.getNextStudentId());
			students.add(student);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Student> getStudents() {
		return students;
	}

	@Override
	public boolean deleteStudent(Student student) {
		boolean status=false;
		try {
			ListIterator<Student> listIterator = students.listIterator();
			while(listIterator.hasNext()) {
			    Student s = listIterator.next();
			    if(student.getStudent_id() == s.getStudent_id()) {
			    	listIterator.remove();
			    	status=true;
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Student> getStudentByID(Student student) {
		List<Student> students = new ArrayList<Student>();
		try {
			ListIterator<Student> listIterator = students.listIterator();
			while(listIterator.hasNext()) {
			    Student s = listIterator.next();
			    if(student.getStudent_id() == s.getStudent_id()) {
			    	listIterator.remove();
			    	students.add(s);
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean status=false;
		try {
			ListIterator<Student> listIterator = students.listIterator();
			while(listIterator.hasNext()) {
			    Student s = listIterator.next();
			    if(student.getStudent_id() == s.getStudent_id()) {
			    	if(student.getStudent_name() != null) {
			    		s.setStudent_name(student.getStudent_name());
			    	}
			    	if(student.getStudent_email() != null) {
			    		s.setStudent_email(student.getStudent_email());
			    	}
			    	if(student.getStudent_branch() != null) {
			    		s.setStudent_branch(student.getStudent_branch());
			    	}
			    	status=true;
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private int getNextStudentId() {
		return students.size()+1;
	}
	
}
