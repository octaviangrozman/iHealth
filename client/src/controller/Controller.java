package controller;

import java.util.ArrayList;

import model.Account;
import model.Consultation;
import model.ConsultationList;
import model.Doctor;
import model.Model;
import model.MyDate;
import model.Patient;
import serverConnection.MessageManager;

public class Controller 
{
	private static Controller instance;
	private MessageManager messageManager;
	private LogInProxy proxy;
	private Model model;
	
	private Controller()
	{
		messageManager = new MessageManager();
		model = Model.getInstance();
	}
	
	public static Controller getInstance()
	{
		if(instance == null)
		{
			instance = new Controller();
		}
		return instance;
	}
	private void useProxy(String result)
	{
		proxy = LogInProxy.getInstance();
		proxy.useProxy(result);
	}
	
	public void logIn(String cpr, String password)
	{
		Account account = new Account();
		account.setDoctorCPR(cpr);
		account.setPatientCPR(cpr);
		account.setPassword(password);
		String result = messageManager.logIn(account);
		if (!result.equals("FAIL")) {
			useProxy(result);
		}
	}
	
	public boolean existPatient(String CPR)
	{
		try
		{
			if(model.getPatients().getPatientByCpr(CPR) != null)
			{
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}
		return false;
	}
	public ArrayList<Patient> getAllPatients() {
		return model.getPatients().getPatientList();
	}
	//added by me
	public Patient getPatientByIndex(int index)
	{
		return model.getPatients().get(index);
	}
	//made two of them one to take from model one to take from db
	public Patient getPatientByCprFromModel(String CPR) {
		return model.getPatients().getPatientByCpr(CPR);
	}
	public boolean getPatientByCprFromDB(String CPR) {
		if(messageManager.getPatient(CPR))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Patient getPatientByName(String name) {
		return model.getPatients().getPatientByName(name);
	}
	
	public boolean addPatient(Patient patient, String password) {
		return messageManager.addPatient(patient, password);
	}
	//remove patient from model
	public void removePatientFromModel(String CPR)
	{
		model.getPatients().removePatientByCPR(CPR);
	}
	public boolean removePatient(String CPR) {
		return messageManager.removePatient(CPR);
	}
	
	public boolean updatePatient(Patient patient) {
		return messageManager.updatePatient(patient);
	}

	
	// Doctor methods
	public ArrayList<Doctor> getAllDoctors() {
		return model.getDoctors().getDoctorList();
	}
	
	public Doctor getDoctorByCpr(String CPR) {
		return model.getDoctors().getDoctorByCpr(CPR);
	}
	public Doctor getDoctorByIndex(int index)
	{
		return model.getDoctors().get(index);
	}
	public Doctor getDoctorByName(String name) {
		return model.getDoctors().getDoctorByName(name);
	}
	
	public boolean addDoctor(Doctor doctor, String password) {
		return messageManager.addDoctor(doctor, password);
	}
	
	public boolean removeDoctor(String CPR) {
		return messageManager.removeDoctor(CPR);
	}
	
	public boolean updateDoctor(Doctor doctor) {
		return messageManager.updateDoctor(doctor);
	}
	
	
	// Consultation methods
	public ArrayList<Consultation> getAllConsultations() {
		return model.getConsultations().getConsultationList();
	}
	
	public Consultation getConsultationByDoctorCpr(String doctorCPR) {
		return model.getConsultations().getConsultationByDoctorCpr(doctorCPR);
	}
	public ArrayList<Consultation> getConsultationsByDoctorCpr(String CPR) {
		return model.getConsultations().getConsultationsByDoctorCpr(CPR);
	}
	public Consultation getConsultationByDate(MyDate date) {
		return model.getConsultations().getConsultationByDate(date);
	}
	
	public Consultation getConsultationById(int id) {
		return model.getConsultations().getConsultationById(id);
	}
	
	public boolean addConsultation(Consultation consultation) {
		return messageManager.addConsultation(consultation);
	}
	
	public boolean removeConsultation(int id) {
		return messageManager.removeConsultation(id);
	}
	
	public boolean updateConsultation(Consultation consultation) {
		return messageManager.updateConsultation(consultation);
	}
	public ArrayList<Consultation> getConsultations(String patientCPR)
	{
		return model.getConsultations().getConsultationByPatientCpr(patientCPR);
	}
	
	
}