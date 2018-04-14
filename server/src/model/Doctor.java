package model;

import java.io.Serializable;
import java.util.Date;


public class Doctor implements Serializable{

	private String CPR;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private MyDate birthday;
	private String office;
	private String officePhoneNumber;
	private String speciality;
	
	public Doctor()
	{
	}

	public String getCPR() {
		return CPR;
	}

	public Doctor setCPR(String CPR) {
		this.CPR = CPR;
		return this;
	}

	public String getName() {
		return name;
	}

	public Doctor setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Doctor setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Doctor setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Doctor setEmail(String email) {
		this.email = email;
		return this;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public Doctor setBirthday(MyDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public String getOffice() {
		return office;
	}

	public Doctor setOffice(String office) {
		this.office = office;
		return this;
	}

	public String getOfficePhoneNumber() {
		return officePhoneNumber;
	}

	public Doctor setOfficePhoneNumber(String officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
		return this;
	}

	public String getSpeciality() {
		return speciality;
	}

	public Doctor setSpeciality(String speciality) {
		this.speciality = speciality;
		return this;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Doctor)
		{
			Doctor doc = (Doctor) obj;
			return (this.CPR.equals(doc.getCPR()));
		}
		else return false;
	}
	public String toString()
	{
		String all = String.format("Doctor (%s) - CPR (%s)", this.name, this.CPR);
		return all;
	}
	
}
