package org.cap.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.ws.soap.Addressing;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Cap_FLP_Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please Enter FirstName.")
	private String firstName;
	
	@NotEmpty(message="* Please Enter lastName.")
	private String lastName;
	
	@Email(message="* please enter the valid email")
	private String email;
	
	@Past(message="* date of birth must be past date.")
	private Date empDob;
	
	@Future(message= "* date of joining must be a future date")
	private Date empDoj;
	
	@NotEmpty(message="* Please Enter address.")
	private String address;
	
	
	private long phone;
	private String department;
	private String project;
	private String role;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", empDob=" + empDob + ", empDoj=" + empDoj + ", address=" + address + ", phone=" + phone
				+ ", department=" + department + ", project=" + project + ", role=" + role + "]";
	}

	
	

}
