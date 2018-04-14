package serverConnection;
import interfaces.IAccountDAO;
import interfaces.IConsultationDAO;
import interfaces.IDoctorDAO;
import interfaces.IPatientDAO;

import java.io.IOException;

import model.*;

import java.sql.SQLException;
import java.util.ArrayList;

import databaseConnection.AccountDAO;
import databaseConnection.ConsultationDAO;
import databaseConnection.DoctorDAO;
import databaseConnection.PatientDAO;

public class ClientManager 
{
	private ArrayList<ServerConnection> connections = new ArrayList<>();
	private IAccountDAO accountDAO;
	private IConsultationDAO consultationDAO;
	private IDoctorDAO doctorDAO;
	private IPatientDAO patientDAO;
	private final String adminUser = "admin";
	private final String adminPassword = "admin";
	
	public ClientManager()
	{
		try {
			consultationDAO = new ConsultationDAO();
			accountDAO = new AccountDAO();
			doctorDAO = new DoctorDAO();
			patientDAO = new PatientDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public synchronized void addConnection(ServerConnection c)
	{
		connections.add(c);
	}
	private synchronized Message logInSystem(Account a)
	{
		if(a.getDoctorCPR().equals(adminUser) && a.getPassword().equals(adminPassword))
		{
			Message req = new Message();
			req.setRequest("admin");
			Message result = getInfoFromDB(req);
			result.setResult("OK ADMIN");
			return result;
		}
		else
		{
			Account test1 = new Account();
			test1.setDoctorCPR(a.getDoctorCPR());
			test1.setPassword(a.getPassword());
			Message testMessage = new Message();
			testMessage.setRequest("");
			testMessage.setAccount(test1);
			Message result1 = getInfoFromDB(testMessage);
			if(result1.getResult().equals("OK DOCTOR"))
			{
				return result1;
			}
			else
			{
				Account test2 = new Account();
				test2.setPatientCPR(a.getPatientCPR());
				test2.setPassword(a.getPassword());
				Message testMessage2 = new Message();
				testMessage2.setRequest("");
				testMessage2.setAccount(test2);
				return getInfoFromDB(testMessage2);
			}
		}
	}
	public synchronized Message communicateWithDB(Message m)
	{
		System.out.println("Got request: " + m.getRequest());
		Message result = new Message();
		if(m.getRequest().equalsIgnoreCase("log in"))
		{
			result = logInSystem(m.getAccount());
		}
		else if(m.getRequest().equals("get patient"))
		{
			result = getPatientByCPR(m);
		}
		else
		{
			result.setResult(sendInfoToDB(m));
		}
		return result;
	}
	private synchronized Message getInfoFromDB(Message m)
	{
		Message backToClient = new Message();
		if(m.getRequest().equals("admin"))
		{
			try {
				backToClient.setDoctors(doctorDAO.getAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				backToClient.setPatients(patientDAO.getAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return backToClient;
		}
		else
		{
		String result = "";
		try
		{
			result = accountDAO.checkAccount(m.getAccount());
			switch(result.toUpperCase())
			{
				case "OK PATIENT": backToClient.setDoctors(doctorDAO.getDoctorsByPatientCPR(m.getAccount().getPatientCPR()));
				backToClient.setConsultations(consultationDAO.getByPatientCPR(m.getAccount().getPatientCPR()));
				backToClient.setPatients(new PatientList().addPatient(patientDAO.getByCpr(m.getAccount().getPatientCPR())));
				break;
				case "OK DOCTOR":  backToClient.setPatients(patientDAO.getByDoctorCpr(m.getAccount().getDoctorCPR()));
				backToClient.setConsultations(consultationDAO.getByDoctorCPR(m.getAccount().getDoctorCPR()));
				backToClient.setDoctors(new DoctorList().addDoctor(doctorDAO.getByCPR(m.getAccount().getDoctorCPR())));
				break;
				case "FAIL": backToClient.setResult("FAIL");
				break;
				default: backToClient.setResult("FAIL");
				break;
			}
		}
		catch(Exception e)
		{
			backToClient.setResult("FAIL");
			return backToClient;
		}
		backToClient.setResult(result);
		return backToClient;
		}
	}
	private synchronized Message getPatientByCPR(Message m)
	{
		Patient p = null;
		Message response = new Message();
		try {
			p = patientDAO.getByCpr(m.getPatients().get(0).getCPR());
			response.setPatients(new PatientList().addPatient(p));
			response.setResult("OK");
			return response;
		} catch (SQLException e) {
			m.setResult("FAIL");
			return m;
		}
	}
	private synchronized String sendInfoToDB(Message m)
	{
		try
		{
			switch(m.getRequest().toLowerCase())
			{
				case "add doctor": return doctorDAO.create(m.getDoctors().get(0), m.getAccount());
				case "update doctor": return doctorDAO.update(m.getDoctors().get(0));
				case "remove doctor": return doctorDAO.remove(m.getDoctors().get(0).getCPR());
				case "add patient": return patientDAO.create(m.getPatients().get(0), m.getAccount());
				case "update patient": return patientDAO.update(m.getPatients().get(0));
				case "remove patient": return patientDAO.remove(m.getPatients().get(0).getCPR());
				case "add consultation": return consultationDAO.create(m.getConsultations().get(0));
				case "update consultation": return consultationDAO.update(m.getConsultations().get(0));
				case "remove consultation": return consultationDAO.remove(m.getConsultations().get(0).getId());
				default: return "FAIL";
			}
		}
		catch(Exception e)
		{e.printStackTrace(); return "FAIL";}
	}
}

