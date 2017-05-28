package com.assessment2.imcs.business;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;

import com.assessment2.imcs.classes.Passenger;
import com.assessment2.imcs.repository.PassengerOperationInterface;

public class PassengerOperationImp implements PassengerOperationInterface{

	private DaoImplementation daoImplementation;
	
	public boolean createPassanger(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.save(passenger);
		return true;
	}

	public Passenger findPassenger(int profile_id) {
		Passenger passengerprofile = daoImplementation.get(profile_id);
		return passengerprofile;
	}

	public boolean deletePassenger(int profile_id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.delete(profile_id);
		return true;
	}

	public boolean updatepassenger(Passenger passenger) throws SecurityException, HibernateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.update(passenger);
		return true;	
	}

}
