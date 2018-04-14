package databaseConnection;

import interfaces.IPatientDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Account;
import model.MyDate;
import model.Patient;
import model.PatientList;

import org.postgresql.Driver;

public class PatientDAO implements IPatientDAO{
	public PatientDAO() throws SQLException {
		DriverManager.registerDriver(new Driver());
	}
	
	public String create(Patient patient, Account account) throws SQLException {
		
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement1 = connection
					.prepareStatement("INSERT INTO Patient(CPR, name, address, phoneNumber, email, birthday, sex, bloodType, registrationDate)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			prepareStatement1.setString(1, patient.getCPR());
			prepareStatement1.setString(2, patient.getName());
			prepareStatement1.setString(3, patient.getAddress());
			prepareStatement1.setString(4, patient.getPhoneNumber());
			prepareStatement1.setString(5, patient.getEmail());
			MyDate d = patient.getBirthday().copy();
			d.MyDateDB();
			prepareStatement1.setDate(6, new java.sql.Date(d.getYear(),d.getMonth(),d.getDay()));
			prepareStatement1.setString(7, String.valueOf(patient.getSex()));
			prepareStatement1.setString(8, patient.getBloodType());
			MyDate date = new MyDate();
			date.MyDateDB();
			prepareStatement1.setDate(9, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()));
			prepareStatement1.executeUpdate();
			
			PreparedStatement prepareStatement2 = connection
					.prepareStatement("INSERT INTO Account("
					+ "patientCPR, doctorCPR, password) "
					+ "VALUES (?, ?, ?)");
			prepareStatement2.setString(1, account.getPatientCPR());
			prepareStatement2.setString(2, account.getDoctorCPR());
			prepareStatement2.setString(3, account.getPassword());
			int count = prepareStatement2.executeUpdate();
			return Utils.getResponse(count);
			
		} 
		catch(Exception e) {
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String remove(String CPR) throws SQLException {
		
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement1 = connection
					.prepareStatement("DELETE FROM Patient WHERE CPR = ?");
			prepareStatement1.setString(1, CPR);
			
			PreparedStatement prepareStatement2 = connection
					.prepareStatement("DELETE FROM Account WHERE patientCPR = ?");
			prepareStatement2.setString(1, CPR);
			
			PreparedStatement prepareStatement3 = connection
					.prepareStatement("DELETE FROM Consultation WHERE patientCPR = ?");
			prepareStatement3.setString(1, CPR);
			
			int count = 0;
			prepareStatement3.executeUpdate();
			count = prepareStatement2.executeUpdate();
			count = count + prepareStatement1.executeUpdate();
			return Utils.getResponse(count, 2);
			
		} 
		catch(Exception e) {
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String update(Patient patient) throws SQLException {
		
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement1 = connection
					.prepareStatement("UPDATE Patient SET "
							+ "CPR = ?, name = ?, address = ?, phoneNumber = ? , email = ?, birthday = ?, sex = ?, bloodType = ?"
							+ "WHERE CPR = ?");
			prepareStatement1.setString(1, patient.getCPR());
			prepareStatement1.setString(2, patient.getName());
			prepareStatement1.setString(3, patient.getAddress());
			prepareStatement1.setString(4, patient.getPhoneNumber());
			prepareStatement1.setString(5, patient.getEmail());
			MyDate copy = patient.getBirthday().copy();
			copy.MyDateDB();
			prepareStatement1.setDate(6, new java.sql.Date(copy.getYear(),copy.getMonth(),copy.getDay()));
			prepareStatement1.setString(7, String.valueOf(patient.getSex()));
			prepareStatement1.setString(8, patient.getBloodType());
//			MyDate date = new MyDate();
//			date.MyDateDB();
//			prepareStatement1.setDate(9, new java.sql.Date(date.getYear()));
			prepareStatement1.setString(9, patient.getCPR());
			prepareStatement1.executeUpdate();
			
			return "OK";
			
		} 
		catch(Exception e) {
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	private void setPatientData(Patient patient, ResultSet result) throws SQLException {
		patient.setCPR(result.getString("CPR"))
		.setName(result.getString("name"))
		.setAddress(result.getString("address"))
		.setPhoneNumber(result.getString("phoneNumber"))
		.setEmail(result.getString("email"))
		.setBirthday(new MyDate().castToDate(result.getDate("birthday")))
		.setSex(result.getString("sex").charAt(0))
		.setBloodType(result.getString("bloodType"))
		.setRegistrationDate(new MyDate().castToDate(result.getDate("registrationDate")));
	}
	
	
	public Patient getByCpr(String CPR) throws SQLException{
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM Patient WHERE CPR = ?");
			prepareStatement.setString(1, CPR);
			
			ResultSet result = prepareStatement.executeQuery();
			
			Patient patient = new Patient();
			
			if(result.next()) {
				setPatientData(patient, result);
			}
			return patient;
		}
		finally {
			connection.close();
		}
	}
	
	public PatientList getAll() throws SQLException{
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM Patient");
			
			ResultSet result = prepareStatement.executeQuery();
			
			PatientList patients = new PatientList();
			
			while(result.next()) {
				if(!result.getString("cpr").equals("0000000000"))
				{
					Patient patient = new Patient();
					setPatientData(patient, result);
					patients.addPatient(patient);
				}
			}
			return patients;
		}
		finally {
			connection.close();
		}
	}
	
	public PatientList getByDoctorCpr(String doctorCPR) throws SQLException{
		Connection connection = Utils.getConnection();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM Patient WHERE CPR IN (SELECT PatientCpr FROM Consultation WHERE DoctorCpr = ?)");
			prepareStatement.setString(1, doctorCPR);
			ResultSet result = prepareStatement.executeQuery();
			
			PatientList patients = new PatientList();
			
			while(result.next()) {
				Patient patient = new Patient();
				setPatientData(patient, result);
				patients.addPatient(patient);
			}
			return patients;
		}
		finally {
			connection.close();
		}
	}
	
}
