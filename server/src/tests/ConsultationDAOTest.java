package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Account;
import model.Consultation;
import model.Doctor;
import model.MyDate;
import model.Patient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import databaseConnection.ConsultationDAO;
import databaseConnection.DoctorDAO;
import databaseConnection.PatientDAO;

public class ConsultationDAOTest {

	private String consultationId = "";
	
	@Before
	public void createDoctorAndPatient() throws SQLException {
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
		
		doctorDAO.create(doctor, account);
		
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = new Patient();
		Account account1 = new Account();
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
		
		patientDAO.create(patient, account1);
	}
	
	@After 
	public void deleteDoctorAndPatient() throws SQLException {
		DoctorDAO doctorDAO = new DoctorDAO();
		doctorDAO.remove("3124567890");
		
		PatientDAO patientDAO = new PatientDAO();
		patientDAO.remove("2134567890");
	}
	
	@Test
	public void test() throws SQLException {
		addConsultation();
		updateConsultation();
		removeConsultation();
	}
	
	public void addConsultation() throws SQLException {
		ConsultationDAO consultationDAO = new ConsultationDAO();
		Consultation consultation = new Consultation();
		consultation.setDoctorCPR("3124567890")
				.setPatientCPR("2134567890")
				.setNotes("fake notes");
		
		consultationId = consultationDAO.create(consultation);
		assertTrue(consultationId != "");
	}
	
	public void updateConsultation() throws SQLException {
		ConsultationDAO consultationDAO = new ConsultationDAO();
		Consultation consultation = new Consultation();
		consultation.setDoctorCPR("3124567890")
				.setPatientCPR("2134567890")
				.setNotes("fake updated notes")
				.setId(Integer.parseInt(consultationId));
		
		String result = consultationDAO.update(consultation);
		assertEquals(result, "OK");
	}
	
	public void removeConsultation() throws SQLException {
		ConsultationDAO consultationDAO = new ConsultationDAO();
		String result = consultationDAO.remove(Integer.parseInt(consultationId));
		assertEquals(result, "OK");
	}

}
