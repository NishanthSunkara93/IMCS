package com.employeeDAO;

import java.util.List;

import javax.management.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pojo.Employee;
import util.HibernateUtil;

public class EmployeeDAOImplementation implements EmployeeDAO {


	HibernateUtil hibernateUtil = new HibernateUtil();
	SessionFactory factory = hibernateUtil.buildSessionFactory();
	Session session = factory.openSession(); 	
	EmployeeDAOImplementation daoImplementation = new EmployeeDAOImplementation();

	public boolean save(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
		return true;
	}

	public Employee get(int id) {
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.getTransaction().commit();
		session.close();

		return employee;
	}

	public boolean delete(int id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {

		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		String hql = "delete Employee where id =: id";
		Query query = (Query) session.createQuery(hql).setParameter("id", id);
		((org.hibernate.Query) query).executeUpdate();
		transaction.commit();
		session.close();
		return true;


	}

	public boolean update(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {

		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.update(employee);

		transaction.commit();
		session.close();

		return true;
	}

	public List<Employee> getAll() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		return employees;
	}




}
