package model;

import java.io.Serializable;
import java.util.ArrayList;


public class PatientList implements Serializable{

	private ArrayList<Patient> patients;
	
	public PatientList()
	{
		this.patients = new ArrayList<>();
	}
	public void setPatientList(ArrayList<Patient> patients)
	{
		this.patients = patients;
	}
	public ArrayList<Patient> getPatientList()
	{
		return this.patients;
	}
	public PatientList addPatient(Patient patient)
	{
		this.patients.add(patient);
		return this;
	}
	public void removePatient(Patient patient)
	{
		if(patients.contains(patient))
		{
			patients.remove(patient);
		}
	}
	public void removePatientByCPR(String CPR)
	{
		for(int i = 0; i < patients.size(); i++)
		{
			if(patients.get(i).getCPR().equals(CPR))
			{
				patients.remove(i);
			}
		}
	}
	public void removePatientByIndex(int index)
	{
		if(index < patients.size())
		{
			patients.remove(index);
		}
	}
	public Patient getPatient(Patient patient)
	{
		if(patients.contains(patient))
		{
			return patients.get(patients.indexOf(patient));
		}
		else return null;
	}
	public Patient getPatientByCpr(String CPR)
	{
		for(int i = 0; i<patients.size(); i++)
		{
			if(patients.get(i).getCPR().equals(CPR))
			{
				return patients.get(i);
			}
		}
		return null;
	}
	public Patient getPatientByName(String name)
	{
		for(int i = 0; i<patients.size(); i++)
		{
			if(patients.get(i).getName().toLowerCase().contains(name.toLowerCase()))
			{
				return patients.get(i);
			}
		}
		return null;
	}
	public Patient get(int index)
	{
		if(index < patients.size())
		{
			return patients.get(index);
		}
		else return null;
	}
	public int size()
	{
		return patients.size();
	}
}
