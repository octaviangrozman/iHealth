package model;

public class Model {

	private static Model instance;
	
	private DoctorList doctors;
	private PatientList patients;
	private ConsultationList consultations;
	
	private Model()
	{}
	public static Model getInstance()
	{
		if(instance == null)
		{
			instance = new Model();
		}
		return instance;
	}
	public DoctorList getDoctors() {
		if(doctors == null)
		{
			doctors = new DoctorList();
		}
		return doctors;
	}
	public void setDoctors(DoctorList doctors) {
		this.doctors = doctors;
	}
	public PatientList getPatients() {
		if(patients == null)
		{
			patients = new PatientList();
		}
		return patients;
	}
	public void setPatients(PatientList patients) {
		this.patients = patients;
	}
	public ConsultationList getConsultations() {
		if(consultations == null)
		{
			consultations = new ConsultationList();
		}
		return consultations;
	}
	public void setConsultations(ConsultationList consultations) {
		this.consultations = consultations;
	}
}
