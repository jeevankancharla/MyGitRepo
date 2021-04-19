package com.te.springmvc.dao;

import com.te.springmvc.bean.EmployeeBean;

public interface EmployeeDAO {
	
	public EmployeeBean authenticate(int id , String password);
	
	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmp(int id);
	

}
