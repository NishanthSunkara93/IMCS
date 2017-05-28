package com.assessment2.imcs.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assessment2.imcs.classes.Passenger;
import com.assessment2.imcs.repository.DaoInterface;

import net.sf.ehcache.hibernate.HibernateUtil;

import javax.management.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoImplementation implements DaoInterface {

	com.assessment2.imcs.util.HibernateUtil hibernateUtil = new com.assessment2.imcs.util.HibernateUtil();
	SessionFactory factory = hibernateUtil.buildSessionFactory();
	Session session = factory.openSession(); 	
	DaoImplementation daoImplementation = new DaoImplementation();

	public boolean save(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.save(passenger);
		transaction.commit();
		session.close();
		return false;
	}

	public Passenger get(int profile_id) {
		factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Passenger passenger = (Passenger) session.get(Passenger.class, profile_id);
		session.getTransaction().commit();
		session.close();

		return passenger;	
	}

	public boolean delete(int profile_id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		String hql = "delete Employee where id =: id";
		Query query = (Query) session.createQuery(hql).setParameter("id", profile_id);
		((org.hibernate.Query) query).executeUpdate();
		transaction.commit();
		session.close();
		return true;
	}

	public boolean update(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, HibernateException {
		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.update(passenger);

		transaction.commit();
		session.close();

		return true;
	}

}
