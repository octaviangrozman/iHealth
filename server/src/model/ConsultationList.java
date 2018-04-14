package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ConsultationList implements Serializable{

	private ArrayList<Consultation> consultations;
	
	public ConsultationList()
	{
		this.consultations = new ArrayList<>();
	}
	public void setConsultationList(ArrayList<Consultation> consultations)
	{
		this.consultations = consultations;
	}
	public ArrayList<Consultation> getConsultationList()
	{
		return consultations;
	}
	public void addConsultation(Consultation consultation)
	{
		consultations.add(consultation);
	}
	public void removeConsultation(Consultation consultation)
	{
		if(consultations.contains(consultation))
		{
			consultations.remove(consultation);
		}
	}
	public void removeConsultationById(int id)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getId() == id)
			{
				consultations.remove(i);
			}
		}
	}
	public void removeConsultationByDoctorCPR(String doctorCPR)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getDoctorCPR().equals(doctorCPR))
			{
				consultations.remove(i);
			}
		}
	}
	public void removeConsultationByPatientCPR(String patientCPR)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getPatientCPR().equals(patientCPR))
			{
				consultations.remove(i);
			}
		}
	}
	public Consultation getConsultation(Consultation consultation)
	{
		if(consultations.contains(consultation))
		{
			return consultations.get(consultations.indexOf(consultation));
		}
		else return null;
	}
	public ArrayList<Consultation> getConsultationsByDoctorCpr(String CPR) {
		ArrayList<Consultation> cons = new ArrayList<>();
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getDoctorCPR().equals(CPR))
			{
				cons.add(consultations.get(i));
			}
		}
		return cons;
	}
	public Consultation getConsultationByDoctorCpr(String CPR)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getDoctorCPR().equals(CPR))
			{
				return consultations.get(i);
			}
		}
		return null;
	}
	//new method for consultations
		public ArrayList<Consultation> getConsultationByPatientCpr(String CPR)
		{
			ArrayList<Consultation> cons = new ArrayList<>();
			for(int i = 0; i < consultations.size(); i++)
			{
				if(consultations.get(i).getPatientCPR().equals(CPR))
				{
					cons.add(consultations.get(i));
				}
			}
			return cons;
		}
	public Consultation getConsultationByDate(MyDate date)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getDate().equals(date))
			{
				return consultations.get(i);
			}
		}
		return null;
	}
	public Consultation getConsultationByIndex(int index)
	{
		if(index < consultations.size())
		{
			return consultations.get(index);
		}
		else return null;
	}
	public Consultation getConsultationById(int id)
	{
		for(int i = 0; i < consultations.size(); i++)
		{
			if(consultations.get(i).getId() == id)
			{
				return consultations.get(i);
			}
		}
		return null;
	}
	public Consultation get(int index)
	{
		if(index < consultations.size())
		{
			return consultations.get(index);
		}
		else return null;
	}
	public int size()
	{
		return consultations.size();
	}
}
