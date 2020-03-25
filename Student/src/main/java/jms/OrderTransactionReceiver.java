package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import DAO.Student_DAO;
import Model.Student;

@Component
public class OrderTransactionReceiver {

  @Autowired private Student_DAO transactionRepository;

  private int count = 1;

	/*
	 * @JmsListener(destination = "OrderTransactionQueue", containerFactory =
	 * "myFactory") public void receiveMessage(Student student) {
	 * System.out.println("<" + count + "> Received <" + student + ">"); count++; //
	 * throw new RuntimeException(); transactionRepository.saveStudent(student); }
	 */
}
