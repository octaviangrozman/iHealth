package interfaces;

import java.sql.SQLException;

import model.Account;
import model.Doctor;
import model.DoctorList;

public interface IDoctorDAO 
{
	String create(Doctor doctor, Account account)throws SQLException;
	String remove(String doctorCPR)throws SQLException;
	String update(Doctor doctor)throws SQLException;
	Doctor getByCPR(String doctorCPR)throws SQLException;
	DoctorList getAll()throws SQLException;
	DoctorList getDoctorsByPatientCPR(String patientCPR)throws SQLException;
}
