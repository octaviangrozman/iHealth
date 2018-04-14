package serverConnection;

import interfaces.IAccountDAO;
import interfaces.IConsultationDAO;
import interfaces.IDoctorDAO;
import interfaces.IPatientDAO;

import java.sql.SQLException;

import databaseConnection.*;

public class DAOWrapper 
{
	private IAccountDAO accountDAO;
	private ConsultationDAO consultationDAO;
	private IDoctorDAO doctorDAO;
	private IPatientDAO patientDAO;
	
	public DAOWrapper(){
		try {
			consultationDAO = new ConsultationDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized IAccountDAO getAccountDAO() 
	{
		if(accountDAO == null)
		{
			try {
				accountDAO = new AccountDAO();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accountDAO;
	}
	
	public synchronized ConsultationDAO getConsultationDAO() 
	{
//		if(consultationDAO == null)
//		{
//			try {
//				consultationDAO = new ConsultationDAO();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return consultationDAO;
	}

	public synchronized IDoctorDAO getDoctorDAO() {
		if(doctorDAO == null)
		{
			try {
				doctorDAO = new DoctorDAO();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doctorDAO;
	}

	public synchronized IPatientDAO getPatientDAO() {
		if(patientDAO == null)
		{
			try {
				patientDAO = new PatientDAO();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return patientDAO;
	}

	
}
