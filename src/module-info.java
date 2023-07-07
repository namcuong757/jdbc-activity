module com.snva.employeelist {
	requires java.sql;
	exports com.snva.employeelist.service;
	exports com.snva.employeelist.bean;
	exports com.snva.employeelist.util;
	exports com.snva.employeelist.service.exception;
	exports com.snva.employeelist.runner;
	exports com.snva.employeelist.uiservice;
}