package com.assessment2.imcs.repository;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;

import com.assessment2.imcs.classes.Passenger;

public interface PassengerOperationInterface {

	boolean createPassanger(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
   
	Passenger findPassenger(int profile_id);

    
    boolean deletePassenger(int profile_id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
    
    boolean updatepassenger(Passenger passenger) throws SecurityException, HibernateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
}
