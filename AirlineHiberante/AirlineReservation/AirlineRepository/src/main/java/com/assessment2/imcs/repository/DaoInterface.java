package com.assessment2.imcs.repository;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.assessment2.imcs.classes.Passenger;

public interface DaoInterface {

	public boolean save(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	public  Passenger get(int profileId);
	public boolean delete(int profile_id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException; 
	public boolean update(Passenger passenger) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
}
