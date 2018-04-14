package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DoctorList implements Serializable{

	private ArrayList<Doctor> doctors;
	
	public DoctorList()
	{
		this.doctors = new ArrayList<>();
	}
	public void setDoctorList(ArrayList<Doctor> doctors)
	{
		this.doctors = doctors;
	}
	public ArrayList<Doctor> getDoctorList()
	{
		return doctors;
	}
	public DoctorList addDoctor(Doctor doctor)
	{
		doctors.add(doctor);
		return this;
	}
	public void removeDoctor(Doctor doctor)
	{
		if(doctors.contains(doctor))
		{
			doctors.remove(doctor);
		}
	}
	public void removeDoctorByIndex(int index)
	{
		if(index < doctors.size())
		{
			doctors.remove(index);
		}
	}
	public void removeDoctorByCPR(String CPR)
	{
		for(int i = 0; i < doctors.size(); i++)
		{
			if(doctors.get(i).getCPR().equals(CPR))
			{
				doctors.remove(i);
			}
		}
	}
	public Doctor getDoctor(Doctor doctor)
	{
		if(doctors.contains(doctor))
		{
			return doctors.get(doctors.indexOf(doctor));
		}
		else return null;
	}
	public Doctor getDoctorByCpr(String CPR)
	{
		for(int i = 0; i < doctors.size(); i++)
		{
			if(doctors.get(i).getCPR().equals(CPR))
			{
				return doctors.get(i);
			}
		}
		return null;
	}
	public Doctor getDoctorByName(String name)
	{
		for(int i = 0; i < doctors.size(); i++)
		{
			if(doctors.get(i).getName().equalsIgnoreCase(name))
			{
				return doctors.get(i);
			}
		}
		return null;
	}
	public Doctor get(int index)
	{
		if(index < doctors.size())
		{
			return doctors.get(index);
		}
		else return null;
	}
	public int size()
	{
		return doctors.size();
	}
	
}
