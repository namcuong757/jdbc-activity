package com.snva.employeelist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import com.snva.employeelist.bean.Employee;

public class DbFeatures implements DbFeaturesInterface{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	public DbFeatures()
	{
		con = config();
		try {
			statement = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override 
	public Connection config()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
			con = DriverManager.getConnection(url, "root", "password123");
			if(con == null)
			{
				System.out.println("Connection Failed");
			}
			else
			{
				System.out.println("Database MySQL connected");
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public List<Employee> import_list() {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		con = config();
		String query = "Select * from Employee;";
		try
		{
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) 
			{
				int eid = resultSet.getInt("EId");
				String fname = resultSet.getString("Fname");
				String lname = resultSet.getString("Lname");
				String designation = resultSet.getString("designation");
				double contactNumber = resultSet.getDouble("contactNumber");
				double salary = resultSet.getDouble("salary");
				Date dob = resultSet.getDate("dateOfBirth");
				Date doj = resultSet.getDate("dateOfJoining");
				Employee employee = new Employee(eid, fname, lname, designation, contactNumber, salary, dob, doj);
				list.add(employee);
			}
		}catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public void export_employee(Employee employee) {
	    String add_employee_query = "INSERT INTO Employee(EId, Fname, Lname, designation, contactNumber, salary, dateOfBirth, dateOfJoining)"
	            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement statement = con.prepareStatement(add_employee_query);

	        // Set the values using the appropriate set methods
	        statement.setInt(1, employee.getEmployeeId());
	        statement.setString(2, employee.getFirstName());
	        statement.setString(3, employee.getLastName());
	        statement.setString(4, employee.getDesignation());
	        statement.setDouble(5, employee.getContactNumber());
	        statement.setDouble(6, employee.getSalary());
	        statement.setDate(7, toSqlDate(employee.getDateOfBirth())); // Assuming getDateOfBirth() returns a java.util.Date object
	        statement.setDate(8, toSqlDate(employee.getDateOfJoining())); // Assuming getDateOfJoining() returns a java.util.Date object

	        int rowAffected = statement.executeUpdate();
	        if (rowAffected > 0) {
	            System.out.println("Saved into Database");
	        } else {
	            System.out.println("Failed to save");
	        }
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void remove_employee(Employee employee) {
		// TODO Auto-generated method stub
		String remove_employee_query = "DELETE FROM Employee Where EId = " + employee.getEmployeeId();
		try {
			statement = con.createStatement();
			int rowAffected = statement.executeUpdate(remove_employee_query);
			if(rowAffected > 0)
			{
				System.out.println("Delete record " + employee.getEmployeeId() + " in Database");
			}
			else
			{
				System.out.println("Failed to delete ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Date toSqlDate(java.util.Date date) {
	    if (date == null) {
	        return null;
	    }

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    long timeInMillis = calendar.getTimeInMillis();
	    return new Date(timeInMillis);
	}
}
