package databaseConnection;

import model.*;
import interfaces.IConsultationDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.postgresql.Driver;

public class ConsultationDAO implements IConsultationDAO {

	public ConsultationDAO() throws SQLException
	{
		DriverManager.registerDriver(new Driver());
	}
	
	public String create(Consultation consultation) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("INSERT INTO Consultation (doctorCPR,patientCPR,notes,date) VALUES (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			prepareStatement.setString(1, consultation.getDoctorCPR());
			prepareStatement.setString(2, consultation.getPatientCPR());
			prepareStatement.setString(3, consultation.getNotes());
			MyDate date = new MyDate();
			date.MyDateDB();
			prepareStatement.setDate(4, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()));
			prepareStatement.executeUpdate();
			ResultSet keys = prepareStatement.getGeneratedKeys();
			if(keys.next())
			{
				return keys.getString(1);
			}
			else
			{
				return "FAIL";
			}
		}
		catch(Exception e)
		{
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String remove(int id) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("DELETE FROM Consultation WHERE id = ?");
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
			
			return "OK";
		}
		catch(Exception e)
		{
			return "FAIL";
		}
		finally {
			connection.close();
		}
	}
	
	public String update(Consultation consultation) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("UPDATE Consultation SET doctorCPR = ?,patientCPR = ?,notes = ? WHERE consultation.id = ?");
			prepareStatement.setString(1, consultation.getDoctorCPR());
			prepareStatement.setString(2, consultation.getPatientCPR());
			prepareStatement.setString(3, consultation.getNotes());
//			MyDate date = consultation.getDate().copy();
//			date.MyDateDB();
//			prepareStatement.setDate(4, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()));
			prepareStatement.setInt(4, consultation.getId());
			int count = prepareStatement.executeUpdate();
			return Utils.getResponse(count);
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
	
	public ConsultationList getByDoctorCPR(String doctorCPR) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT * FROM Consultation WHERE doctorCPR = ?");
			prepareStatement.setString(1, doctorCPR);
			
			ResultSet result = prepareStatement.executeQuery();
			ConsultationList consultations = new ConsultationList();
			while(result.next())
			{
				Consultation consultation = new Consultation();
				setConsultationData(consultation,result);
				consultations.addConsultation(consultation);
			}
			return consultations;
		}
		finally {
			connection.close();
		}
	}
	
	public ConsultationList getByPatientCPR(String patientCPR) throws SQLException
	{
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT * FROM Consultation WHERE patientCPR = ?");
			prepareStatement.setString(1, patientCPR);
			
			ResultSet result = prepareStatement.executeQuery();
			ConsultationList consultations = new ConsultationList();
			while(result.next())
			{
				Consultation consultation = new Consultation();
				setConsultationData(consultation,result);
				consultations.addConsultation(consultation);
			}
			
			return consultations;
		}
		finally {
			connection.close();
		}
	}
	
	private void setConsultationData(Consultation consultation, ResultSet result) throws SQLException
	{
		consultation.setDoctorCPR(result.getString("doctorCPR"))
		.setPatientCPR(result.getString("patientCPR"))
		.setNotes(result.getString("notes"))
		.setId(result.getInt(1))
		.setDate(new MyDate().castToDate(result.getDate(5)));
		
	}
}
