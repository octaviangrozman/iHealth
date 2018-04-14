package interfaces;

import java.sql.SQLException;

import model.Consultation;
import model.ConsultationList;

public interface IConsultationDAO 
{	
	String create(Consultation consultation)throws SQLException;
	String remove(int id)throws SQLException;
	String update(Consultation consultation)throws SQLException;
	ConsultationList getByDoctorCPR(String doctroCPR)throws SQLException;
	ConsultationList getByPatientCPR(String patientCPR)throws SQLException;
}
