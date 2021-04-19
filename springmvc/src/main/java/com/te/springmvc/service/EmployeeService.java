package com.te.springmvc.service;

import com.te.springmvc.bean.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean authenticate(int id , String password);
	
	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmp(int id);
	


}
