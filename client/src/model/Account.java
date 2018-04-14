package model;

import java.io.Serializable;

/**
 * 
 * @author Sebastian
 *
 */

public class Account implements Serializable{

	private String doctorCPR;
	private String patientCPR;
	private String password;
	
	public Account()
	{
		this.doctorCPR = "0000000000";
		this.patientCPR = "0000000000";
	}

	public String getDoctorCPR() {
		return doctorCPR;
	}

	public Account setDoctorCPR(String doctorCPR) {
		this.doctorCPR = doctorCPR;
		return this;
	}

	public String getPatientCPR() {
		return patientCPR;
	}

	public Account setPatientCPR(String patientCPR) {
		this.patientCPR = patientCPR;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Account setPassword(String password) {
		this.password = password;
		return this;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Account)
		{
			Account acc = (Account) obj;
			return (this.doctorCPR.equals(acc.getDoctorCPR()) && this.patientCPR.equals(acc.getPatientCPR()) && this.password.equals(acc.getPassword()));
		}
		else return false;
	}
	public String toString()
	{
		return "Account: DoctorCPR "+doctorCPR +", PatientCPR "+ patientCPR+" - password: "+password;
	}
}
