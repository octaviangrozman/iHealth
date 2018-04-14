package serverConnection;

import model.Account;
import model.Consultation;
import model.ConsultationList;
import model.Doctor;
import model.DoctorList;
import model.Model;
import model.Patient;
import model.PatientList;

public class MessageManager 
{
	private Client client;
	private Model model;
	
	public MessageManager()
	{
		client = Client.getInstance();
		model = Model.getInstance();
	}
	
	public boolean addDoctor(Doctor doctor, String password)
	{
//		if(model.getDoctors().getDoctor(doctor) == null)
//		{
			Message m = new Message();
			m.setRequest("add doctor");
			Account a = new Account();
			a.setDoctorCPR(doctor.getCPR());
			a.setPassword(password);
			DoctorList doctors = new DoctorList();
			doctors.addDoctor(doctor);
			m.setDoctors(doctors);
			m.setAccount(a);
			Message response = null;
			try {
				response = client.sendMessageToServer(m);
			} catch (Exception e) {
				return false;
			}
			if(response.getResult().equals("OK"))
			{
				model.getDoctors().addDoctor(doctor);
				return true;
			}
			else
			{
				return false;
			}
			
		//}
	}
	public boolean updateDoctor(Doctor doctor)
	{
		Message m = new Message();
		m.setRequest("update doctor");
		DoctorList doctors = new DoctorList();
		doctors.addDoctor(doctor);
		m.setDoctors(doctors);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getDoctors().removeDoctorByCPR(doctor.getCPR());
			model.getDoctors().addDoctor(doctor);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean removeDoctor(String doctorCPR)
	{
		Message m = new Message();
		m.setRequest("remove doctor");
		DoctorList doctors = new DoctorList();
		doctors.addDoctor(new Doctor().setCPR(doctorCPR));
		m.setDoctors(doctors);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getDoctors().removeDoctorByCPR(doctorCPR);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean addPatient(Patient patient, String password)
	{

		if(model.getPatients().getPatient(patient) == null)
		{
			Message m = new Message();
			m.setRequest("add patient");
			Account a = new Account();
			a.setPatientCPR(patient.getCPR());
			a.setPassword(password);
			PatientList list = new PatientList();
			list.addPatient(patient);
			m.setPatients(list);
			m.setAccount(a);
			Message response = null;
			try {
				response = client.sendMessageToServer(m);
			} catch (Exception e) {
				return false;
			}
			if(response.getResult().equals("OK"))
			{
				model.getPatients().addPatient(patient);
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else return false;
	}
	public boolean updatePatient(Patient patient)
	{
		Message m = new Message();
		m.setRequest("update patient");
		PatientList list = new PatientList();
		list.addPatient(patient);
		m.setPatients(list);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getPatients().removePatientByCPR(patient.getCPR());
			model.getPatients().addPatient(patient);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean removePatient(String patientCPR)
	{
		Message m = new Message();
		m.setRequest("remove patient");
		PatientList patients = new PatientList();
		patients.addPatient(new Patient().setCPR(patientCPR));
		m.setPatients(patients);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getPatients().removePatientByCPR(patientCPR);
			return true;
		}
		else
		{
			return false;
		}
	}
	public String logIn(Account a)
	{
		Message m = new Message();
		m.setRequest("log in");
		m.setAccount(a);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return "FAIL";
		}
		if(response.getResult().equals("OK DOCTOR"))
		{
			model.setDoctors(response.getDoctors());
			model.setPatients(response.getPatients());
			model.setConsultations(response.getConsultations());
			return "OK DOCTOR";
		}
		else if(response.getResult().equals("OK PATIENT"))
		{
			model.setDoctors(response.getDoctors());
			model.setPatients(response.getPatients());
			model.setConsultations(response.getConsultations());
			return "OK PATIENT";
		}
		else if(response.getResult().equals("OK ADMIN"))
		{
			model.setDoctors(response.getDoctors());
			model.setPatients(response.getPatients());
			return "OK ADMIN";
		}
		else return "FAIL";
	}
	public boolean addConsultation(Consultation consultation)
	{
		Message m = new Message();
		m.setRequest("add consultation");
		ConsultationList list = new ConsultationList();
		list.addConsultation(consultation);
		m.setConsultations(list);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(!response.getResult().equals("FAIL"))
		{
			consultation.setId(Integer.parseInt(response.getResult()));
			model.getConsultations().addConsultation(response.getConsultations().get(0));
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean updateConsultation(Consultation consultation)
	{
		Message m = new Message();
		m.setRequest("update consultation");
		ConsultationList list = new ConsultationList();
		list.addConsultation(consultation);
		m.setConsultations(list);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getConsultations().removeConsultationById(consultation.getId());
			model.getConsultations().addConsultation(consultation);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean removeConsultation(int consultationID)
	{
		Message m = new Message();
		m.setRequest("remove consultation");
		ConsultationList list = new ConsultationList();
		list.addConsultation(new Consultation().setId(consultationID));
		m.setConsultations(list);
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getConsultations().removeConsultationById(consultationID);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean getPatient(String patientCPR)
	{
		Message m = new Message();
		m.setRequest("get patient");
		m.setPatients(new PatientList().addPatient(new Patient().setCPR(patientCPR)));
		Message response = null;
		try {
			response = client.sendMessageToServer(m);
		} catch (Exception e) {
			return false;
		}
		if(response.getResult().equals("OK"))
		{
			model.getPatients().addPatient(response.getPatients().get(0));
			return true;
		}
		else
		{
			return false;
		}
	}
}