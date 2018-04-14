package databaseConnection;

import interfaces.IAccountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Account;

import org.postgresql.Driver;

public class AccountDAO implements IAccountDAO
{
	public AccountDAO() throws SQLException
	{
		DriverManager.registerDriver(new Driver());
	}
	public String create(Account a) throws SQLException
	{
		String n = "FAIL";
		Connection connection = Utils.getConnection();
		try
		{
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO account VALUES(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			prepareStatement.setString(1, a.getDoctorCPR());
			prepareStatement.setString(2, a.getPatientCPR());
			prepareStatement.setString(3, a.getPassword());
			prepareStatement.executeUpdate();
			ResultSet keys = prepareStatement.getGeneratedKeys();
			if(keys.next())
			{
				n = "OK";
			}
			return n;
			
		}
		catch(Exception e)
		{return n;}
		finally {
			connection.close();
		}
	}
	
	public String remove(Account a) throws SQLException
	{
		String n = "FAIL";
		Connection connection = Utils.getConnection();
		try
		{
			PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM account WHERE account.doctorcpr = ? AND account.patientcpr = ? AND account.password = ?");
			prepareStatement.setString(1, a.getDoctorCPR());
			prepareStatement.setString(2, a.getPatientCPR());
			prepareStatement.setString(3, a.getPassword());
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
	
	public String checkAccount(Account a) throws SQLException
	{
		String n = "FAIL";
		Connection connection = Utils.getConnection();
		try
		{
		PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM account WHERE account.password = ? AND account.patientcpr = ? AND account.doctorcpr = ?");
		prepareStatement.setString(1, a.getPassword());
		prepareStatement.setString(2, a.getPatientCPR());
		prepareStatement.setString(3, a.getDoctorCPR());
		ResultSet keys = prepareStatement.executeQuery();
		if(keys.next())
		{
			if(keys.getString(1).equals("0000000000") && keys.getString(2).equals(a.getPatientCPR())&& keys.getString(3).equals(a.getPassword()))
			{
				n = "OK PATIENT";
			}
			else if(keys.getString(1).equals(a.getDoctorCPR()) && keys.getString(2).equals("0000000000")&& keys.getString(3).equals(a.getPassword()))
			{
				n = "OK DOCTOR";
			}
			else
			{
				n = "FAIL";
			}
		}
		else
		{
			n = "FAIL";
		}
		return n;
		}
		catch(Exception e)
		{return n;}
		finally {
			connection.close();
		}
	}
}
