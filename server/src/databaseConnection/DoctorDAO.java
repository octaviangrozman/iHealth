package databaseConnection;

import model.*;
import interfaces.IDoctorDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.postgresql.Driver;

public class DoctorDAO implements IDoctorDAO{

	public DoctorDAO() throws SQLException
	{
		DriverManager.registerDriver(new Driver());
	}
	
	private void setDoctorData(Doctor doctor, ResultSet result) throws SQLException
	{
		doctor.setCPR(result.getString("CPR"))
		.setName(result.getString("name"))
		.setAddress(result.getString("address"))
		.setEmail(result.getString("email"))
		.setBirthday(new MyDate().castToDate(result.getDate("birthday")))
		.setOffice(result.getString("office"))
		.setOfficePhoneNumber(result.getString("officePhoneNumber"))
		.setSpeciality(result.getString("speciality"))
		.setPhoneNumber(result.getString("phonenumber"));
	}
	
	public String create(Doctor doctor, Account account) throws SQLException
	{
		String n = "";
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("INSERT INTO Doctor (CPR,name,address,phoneNumber,email,birthday,office,officePhoneNumber,speciality) VALUES (?,?,?,?,?,?,?,?,?);");
			prepareStatement.setString(1, doctor.getCPR());
			prepareStatement.setString(2, doctor.getName());
			prepareStatement.setString(3, doctor.getAddress());
			prepareStatement.setString(4, doctor.getPhoneNumber());
			prepareStatement.setString(5, doctor.getEmail());
			MyDate date = doctor.getBirthday().copy();
			date.MyDateDB();
			prepareStatement.setDate(6, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()));
			prepareStatement.setString(7, doctor.getOffice());
			prepareStatement.setString(8, doctor.getOfficePhoneNumber());
			prepareStatement.setString(9, doctor.getSpeciality());
			int count = prepareStatement.executeUpdate();
			PreparedStatement prepareStatement2 = connection.prepareStatement("INSERT INTO Account (doctorCPR,patientCPR,password) VALUES (?,?,?);");
			prepareStatement2.setString(1, account.getDoctorCPR());
			prepareStatement2.setString(2, account.getPatientCPR());
			prepareStatement2.setString(3, account.getPassword());
			count = count + prepareStatement2.executeUpdate();
			return Utils.getResponse(count, 2);
			
		}
		catch(Exception e)
		{
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String remove(String doctorCPR) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("DELETE FROM Doctor WHERE CPR = ?");
			prepareStatement.setString(1, doctorCPR);
			
			PreparedStatement prepareStatement2 = connection
				.prepareStatement("DELETE FROM Account WHERE doctorCPR = ?");
			prepareStatement2.setString(1, doctorCPR);
			
			PreparedStatement prepareStatement3 = connection
					.prepareStatement("DELETE FROM Consultation WHERE doctorCPR = ?");
			prepareStatement3.setString(1, doctorCPR);
			int count = 0;
			prepareStatement3.executeUpdate();
			count = prepareStatement2.executeUpdate();
			count = count + prepareStatement.executeUpdate();
			return Utils.getResponse(count, 2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String update(Doctor doctor) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("UPDATE Doctor SET name = ?,address = ?,phoneNumber = ?,email = ?,birthday = ?,office = ?,officePhoneNumber = ?,speciality = ? WHERE CPR = ?");
				prepareStatement.setString(1, doctor.getName());
				prepareStatement.setString(2, doctor.getAddress());
				prepareStatement.setString(3, doctor.getPhoneNumber());
				prepareStatement.setString(4, doctor.getEmail());
				MyDate copy = doctor.getBirthday().copy();
				copy.MyDateDB();
				prepareStatement.setDate(5, new java.sql.Date(copy.getYear(), copy.getMonth(), copy.getDay()));
				prepareStatement.setString(6, doctor.getOffice());
				prepareStatement.setString(7, doctor.getOfficePhoneNumber());
				prepareStatement.setString(8, doctor.getSpeciality());
				prepareStatement.setString(9, doctor.getCPR());
				int count = prepareStatement.executeUpdate();
				return Utils.getResponse(count);
		}
		catch(Exception e)
		{
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public Doctor getByCPR(String doctorCPR) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("SELECT * FROM Doctor WHERE CPR = ?");
				prepareStatement.setString(1, doctorCPR);
				
			ResultSet result = prepareStatement.executeQuery();
			Doctor doctor = new Doctor();
			if(result.next())
			{
				setDoctorData(doctor, result);
			}
			return doctor;
		}
		finally {
			connection.close();
		}
	}
	
	public DoctorList getAll() throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM Doctor");

			ResultSet result = prepareStatement.executeQuery();
			DoctorList doctors = new DoctorList();
			while(result.next())
			{
				if(!result.getString("cpr").equals("0000000000"))
				{
					Doctor doctor = new Doctor();
					setDoctorData(doctor, result);
					doctors.addDoctor(doctor);
				}
			}
			return doctors;
		}
		finally {
			connection.close();
		}
	}
	
	public DoctorList getDoctorsByPatientCPR(String patientCPR) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM Doctor WHERE CPR IN (SELECT doctorCPR FROM Consultation WHERE patientCPR = ?)");
			prepareStatement.setString(1, patientCPR);

			ResultSet result = prepareStatement.executeQuery();
			DoctorList doctors = new DoctorList();
			while(result.next())
			{
				Doctor doctor = new Doctor();
				setDoctorData(doctor, result);
				doctors.addDoctor(doctor);
			}
			return doctors;
		}
		finally {
			connection.close();
		}
	}
		
}
