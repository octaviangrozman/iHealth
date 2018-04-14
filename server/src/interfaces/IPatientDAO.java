package interfaces;

import java.sql.SQLException;

import model.Account;
import model.Patient;
import model.PatientList;

public interface IPatientDAO 
{
	String create(Patient patient, Account a)throws SQLException;
	String remove(String CPR)throws SQLException;
	String update(Patient patient)throws SQLException;
	Patient getByCpr(String CPR)throws SQLException;
	PatientList getAll()throws SQLException;
	PatientList getByDoctorCpr(String doctorCPR)throws SQLException;
	
}
