package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Account;
import model.Doctor;
import model.MyDate;

import org.junit.Before;
import org.junit.Test;

import databaseConnection.DoctorDAO;

public class DoctorDAOTest {

	
	@Test
	public void test() throws SQLException {
		addDoctor();
		updateDoctor();
		removeDoctor();
	}
	
	public void addDoctor() throws SQLException {
		DoctorDAO doctorDAO = new DoctorDAO();
		Doctor doctor = new Doctor();
		Account account = new Account();
		doctor.setAddress("address")
			.setBirthday(new MyDate(1, 6, 1996))
			.setCPR("3124567890")
			.setEmail("TestDoctor")
			.setName("TestDoctor")
			.setPhoneNumber("111")
			.setOffice("A11")
			.setOfficePhoneNumber("12333")
			.setSpeciality("Neurology");
		
		account.setDoctorCPR("3124567890")
			.setPatientCPR("0000000000")
			.setPassword("password");
		
		String result = doctorDAO.create(doctor, account);
		assertEquals(result, "OK");
	}
	
	public void updateDoctor() throws SQLException {
		DoctorDAO doctorDAO = new DoctorDAO();
		Doctor doctor = new Doctor();
		doctor.setAddress("address")
			.setBirthday(new MyDate(1, 6, 1996))
			.setCPR("3124567890")
			.setEmail("test Updated")
			.setName("TestDoctor")
			.setPhoneNumber("111")
			.setOffice("A11")
			.setOfficePhoneNumber("12333")
			.setSpeciality("Neurology");
		
		String result = doctorDAO.update(doctor);
		assertEquals(result, "OK");
	}
	
	public void removeDoctor() throws SQLException {
		DoctorDAO doctorDAO = new DoctorDAO();
		String result = doctorDAO.remove("3124567890");
		assertEquals(result, "OK");
	}

}