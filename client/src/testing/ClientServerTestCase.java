
package testing;

import static org.junit.Assert.*;
import model.Account;
import model.Consultation;
import model.Doctor;
import model.Model;
import model.MyDate;
import model.Patient;

import org.junit.Before;
import org.junit.Test;

import serverConnection.MessageManager;

public class ClientServerTestCase {

	private Model model = Model.getInstance();
	private MessageManager manager = new MessageManager();
	//run server before test
	@Test
	public void TestInRightOrder()
	{
		assertEquals(true, testAddPatient());
		assertEquals(true, testAddDoctor());
		assertEquals(true, testAddConsultation());
		assertEquals(true, testGetPatient());
		assertEquals("OK DOCTOR", testLogIn());
		assertEquals(true, testUpdatePatient());
		assertEquals(true, testUpdateDoctor());
		assertEquals(true, testUpdateConsultation());
		assertEquals(true, testRemoveConsultation());
		assertEquals(true, 	testRemoveDoctor());
		assertEquals(true, testRemovePatient());
	}
	public boolean testAddPatient()
	{
		Patient p = new Patient().setName("Lucian")
				.setAddress("K")
				.setBloodType("b3")
				.setBirthday(new MyDate(10,10,1997))
				.setCPR("0987654321")
				.setEmail("email")
				.setPhoneNumber("52787393")
				.setSex('M');
		return manager.addPatient(p, "pass");
	}
	public boolean testAddDoctor()
	{
		Doctor d = new Doctor().setAddress("k")
				.setBirthday(new MyDate(10,10,1997))
				.setCPR("1010972627")
				.setEmail("email")
				.setName("Lucian")
				.setOffice("a16")
				.setOfficePhoneNumber("52787393")
				.setPhoneNumber("52787393")
				.setSpeciality("neurologist");
		return manager.addDoctor(d, "pass");
	}
	public boolean testAddConsultation()
	{
		Consultation c = new Consultation().setDoctorCPR("1010972627")
				.setPatientCPR("1234567890")
				.setNotes("Test consultation")
				.setDate(new MyDate());
		return manager.addConsultation(c);
	}
	public boolean testUpdatePatient()
	{
		Patient p = new Patient().setName("Lucian")
				.setAddress("K")
				.setBloodType("b3")
				.setBirthday(new MyDate(10,10,1997))
				.setCPR("0987654321")
				.setEmail("luci_crossfire@yahoo.com")
				.setPhoneNumber("52787393")
				.setSex('M');
		return manager.updatePatient(p);
	}
	public boolean testUpdateDoctor()
	{
		Doctor d = new Doctor().setAddress("k")
				.setBirthday(new MyDate(10,10,1997))
				.setCPR("1010972627")
				.setEmail("luci_crossfire@yahoo.com")
				.setName("Lucian")
				.setOffice("a16")
				.setOfficePhoneNumber("52787393")
				.setPhoneNumber("52787393")
				.setSpeciality("neurologist");
		return manager.updateDoctor(d);
	}
	public boolean testUpdateConsultation()
	{
		Consultation c = new Consultation().setDoctorCPR("1010972627")
				.setPatientCPR("0987654321")
				.setNotes("Test again")
				.setDate(new MyDate())
				.setId(model.getConsultations().get(0).getId());
		return manager.updateConsultation(c);
	}
	public boolean testRemovePatient()
	{
		return manager.removePatient("0987654321");
	}
	public boolean testRemoveDoctor()
	{
		return manager.removeDoctor("1010972627");
	}
	public boolean testRemoveConsultation()
	{
		return manager.removeConsultation(model.getConsultations().get(0).getId());
	}
	public String testLogIn()
	{
		Account a = new Account();
		a.setDoctorCPR("1010972627");
		a.setPatientCPR("1010972627");
		a.setPassword("pass");
		return manager.logIn(a);
	}
	public boolean testGetPatient()
	{
		return manager.getPatient("1234567890");
	}
}