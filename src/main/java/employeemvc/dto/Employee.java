package employeemvc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private long empContact;
	private String empEmail;
	private String empPassword;
	private String empCity;
	private double empSalary;
	
	public String getEmpCity() {
		return empCity;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public long getEmpContact() {
		return empContact;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpContact(long empContact) {
		this.empContact = empContact;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public String toString() {
		return "employee [empId=" + empId + ", empName=" + empName + ", empContact=" + empContact + ", empEmail="
				+ empEmail + ", empPassword=" + empPassword + "]";
	}
	
	
}
