package com.snva.employeelist.db;
import java.util.List;

import com.snva.employeelist.bean.Employee;

import java.sql.Connection;

public interface DbFeaturesInterface {
	public Connection config();
	public List<Employee> import_list();
	public void export_employee(Employee employee);
	public void remove_employee(Employee employee);
}
