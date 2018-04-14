package serverConnection;

import java.io.Serializable;

import model.*;

public class Message implements Serializable
{
	private String request;
	private DoctorList doctors;
	private PatientList patients;
	private ConsultationList consultations;
	private Account account;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Message()
	{}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public DoctorList getDoctors() {
		return doctors;
	}

	public void setDoctors(DoctorList doctors) {
		this.doctors = doctors;
	}

	public PatientList getPatients() {
		return patients;
	}

	public void setPatients(PatientList patients) {
		this.patients = patients;
	}

	public ConsultationList getConsultations() {
		return consultations;
	}

	public void setConsultations(ConsultationList consultations) {
		this.consultations = consultations;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}