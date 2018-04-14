package model;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable{

	private String CPR;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private MyDate birthday;
	private char sex;
	private String bloodType;
	private MyDate registrationDate;
	
	public Patient()
	{
		
	}

	public String getCPR() {
		return CPR;
	}

	public Patient setCPR(String CPR) {
		this.CPR = CPR;
		return this;
	}

	public String getName() {
		return name;
	}

	public Patient setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Patient setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Patient setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Patient setEmail(String email) {
		this.email = email;
		return this;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public Patient setBirthday(MyDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public char getSex() {
		return sex;
	}

	public Patient setSex(char sex) {
		this.sex = sex;
		return this;
	}

	public String getBloodType() {
		return bloodType;
	}

	public Patient setBloodType(String bloodType) {
		this.bloodType = bloodType;
		return this;
	}

	public MyDate getRegistrationDate() {
		return registrationDate;
	}

	public Patient setRegistrationDate(MyDate registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Patient)
		{
			Patient patient = (Patient) obj;
			return (this.CPR.equals(patient.getCPR()));
		}
		else return false;
	}
	
}
