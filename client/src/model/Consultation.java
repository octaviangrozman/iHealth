package model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Sebastian
 *
 */

public class Consultation implements Serializable
{
	private int id;
	private String doctorCPR;
	private String patientCPR;
	private String notes;
	private MyDate date;
	
	public Consultation() {}
	
	public Consultation setId(int id)
	{
		this.id = id;
		return this;
	}
	public int getId()
	{
		return id;
	}
	public String getDoctorCPR() {
		return doctorCPR;
	}

	public Consultation setDoctorCPR(String doctorCPR) {
		this.doctorCPR = doctorCPR;
		return this;
	}

	public String getPatientCPR() {
		return patientCPR;
	}

	public Consultation setPatientCPR(String patientCPR) {
		this.patientCPR = patientCPR;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Consultation setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public MyDate getDate() {
		return date;
	}

	public Consultation setDate(MyDate date) {
		this.date = date;
		return this;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Consultation)
		{
			Consultation cons = (Consultation) obj;
			return (this.doctorCPR.equals(cons.getDoctorCPR()) && this.patientCPR.equals(cons.getPatientCPR()) && this.date.equals(cons.getDate()));
		}
		else return false;
	}
	public String toString()
	{
		return date.toString();
	}
}
