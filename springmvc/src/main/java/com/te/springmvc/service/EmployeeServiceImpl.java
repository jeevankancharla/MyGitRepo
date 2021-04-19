package com.te.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDAO;

@Repository
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
private EmployeeDAO dao;

	@Override
	public EmployeeBean authenticate(int id, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(id);
	}

}
