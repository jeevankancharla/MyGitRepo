package com.te.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;

@Repository
public class EmployeeHibernateImpl implements EmployeeDAO {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	@Override
	public EmployeeBean authenticate(int id, String password) {


		try {

			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("login successfull");
					return bean;
				} else {
					System.out.println("invalid credenitials");
					return null;
				}

			} else {

				System.out.println("user not found");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		factory = Persistence.createEntityManagerFactory("spring");
		manager = factory.createEntityManager();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		
		return bean;
	}

	@Override
	public boolean deleteEmp(int id) {
		
		factory = Persistence.createEntityManagerFactory("spring");
		manager = factory.createEntityManager();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		transaction = manager.getTransaction();
		
		try {
			if(bean != null) {
			transaction.begin();
			manager.remove(bean);
			transaction.commit();
			return true ;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
