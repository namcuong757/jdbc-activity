package com.snva.employeelist.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *This is the employee bean.
 */
public class Employee
{
	private int m_employeeId;
	private String m_firstName;
	private String m_lastName;
	private String m_designation;
	private Double m_contactNumber;
	private Double m_salary;
	private Date m_dateOfBirth;
	private Date m_dateOfJoining;
	static int current_id=1;

	public Employee()
	{
		m_employeeId=current_id++;
	}
	public Employee(int m_employeeId, String m_firstName, String m_lastName, String m_designation, Double m_contactNumber, Double m_salary, Date m_dateOfBirth,Date m_dateOfJoining)
	{
		this.m_employeeId = m_employeeId;
		this.m_firstName = m_firstName;
		this.m_lastName = m_lastName;
		this.m_designation = m_designation;
		this.m_contactNumber = m_contactNumber;
		this.m_salary = m_salary;
		this.m_dateOfBirth = m_dateOfBirth;
		this.m_dateOfJoining = m_dateOfJoining;
	}
	public Double getContactNumber() {
		return m_contactNumber;
	}
	public void setContactNumber(Double contactNumber) {
		m_contactNumber = contactNumber;
	}
	public Date getDateOfBirth() {
		return m_dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		m_dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return m_dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		m_dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return m_designation;
	}
	public void setDesignation(String designation) {
		m_designation = designation;
	}
	public int getEmployeeId() {
		return m_employeeId;
	}

	public String getFirstName() {
		return m_firstName;
	}
	public void setFirstName(String firstName) {
		m_firstName = firstName;
	}
	public String getLastName() {
		return m_lastName;
	}
	public void setLastName(String lastName) {
		m_lastName = lastName;
	}
	public Double getSalary() {
		return m_salary;
	}
	public void setSalary(Double salary) {
		m_salary = salary;
	}

}
