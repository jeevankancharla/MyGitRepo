package com.tyss.springCoreProjecto.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.springCoreProject.dto.Login;
import com.tyss.springCoreProject.dto.QuizQuestions;
import com.tyss.springCoreProject.dto.Register;
import com.tyss.springCoreProject.dto.Results;

public class LoginDetails  implements Quiz {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	@Override
	public Register login(String username, String Password) {
		try {
			Register login = null;
			factory = Persistence.createEntityManagerFactory("quiz");
			manager = factory.createEntityManager();
			login = manager.find(Register.class, username);
			return login;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;

	}
	@Override
	public Register register(Register register) {

		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(register);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return register;
	}
	@Override
	public QuizQuestions questions(int id) {
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			manager = factory.createEntityManager();
			QuizQuestions questions = manager.find(QuizQuestions.class, id);
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public void results(Results results) {
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(results);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
	}
	@Override
	public Results getResults(Date date) {
		Results results =null;
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			manager = factory.createEntityManager();
			results = manager.find(Results.class, date);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return results;
	}
	
	

	
}
