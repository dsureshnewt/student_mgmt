package Controller;

import java.util.List;

import javax.jms.Queue;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import Service.Student_Service;
import config.Configu;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://3.21.189.239:8080")
@RequestMapping(value = "/api")
public class Controller {

	@Autowired
	private Configu config;
	
	@Autowired
	private Student_Service studentservice;

    @Autowired
    private JmsTemplate jmsTemplate;

	@PostMapping("save-student")
	public boolean saveStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);	
	}

	@GetMapping("students-list")
	public List<Student> allstudents() {
		return studentservice.getStudents();
	}

	@DeleteMapping("delete-student/{student_id}")
	public boolean deleteStudent(@PathVariable("student_id") int student_id, Student student) {
		student.setStudent_id(student_id);
		return studentservice.deleteStudent(student);
	}

	@GetMapping("student/{student_id}")
	public List<Student> allstudentByID(@PathVariable("student_id") int student_id, Student student) {
		student.setStudent_id(student_id);
		return studentservice.getStudentByID(student);

	}

	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Student student, @PathVariable("student_id") int student_id) {
		student.setStudent_id(student_id);
		return studentservice.updateStudent(student);
	}

}
