package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Account;
import model.MyDate;
import model.Patient;

import org.junit.Test;

import databaseConnection.PatientDAO;

public class PatientDAOTest {

	@Test
	public void test() throws SQLException {
		addPatient();
		updatePatient();
		removePatient();
	}
	
	public void addPatient() throws SQLException {
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = new Patient();
		Account account = new Account();
		patient.setAddress("address")
			.setBirthday(new MyDate(1, 6, 1996))
			.setBloodType("BII")
			.setCPR("2134567890")
			.setEmail("OctavianPatient")
			.setName("OctavianPatient")
			.setPhoneNumber("111")
			.setSex('M');
		
		account.setDoctorCPR("0000000000")
			.setPatientCPR("2134567890")
			.setPassword("password");
		
		String result = patientDAO.create(patient, account);
		assertEquals(result, "OK");
	}
	
	public void updatePatient() throws SQLException {
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = new Patient();
		patient.setAddress("address")
			.setBirthday(new MyDate(1, 6, 1996))
			.setBloodType("BII")
			.setCPR("2134567890")
			.setEmail("updatedMail")
			.setName("OctavianPatient")
			.setPhoneNumber("111")
			.setSex('M');
		
		String result = patientDAO.update(patient);
		assertEquals(result, "OK");
	}
	
	public void removePatient() throws SQLException {
		PatientDAO patientDAO = new PatientDAO();
		String result = patientDAO.remove("2134567890");
		assertEquals(result, "OK");
	}

}
