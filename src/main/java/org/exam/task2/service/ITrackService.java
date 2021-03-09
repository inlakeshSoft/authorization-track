package org.exam.task2.service;

import java.util.List;
import java.util.Optional;

import org.exam.task2.entity.Authorization;

/**
 * Interface to define necessary methods to persist and retrieve each and all authorizations.  
 * 
 * @author Felipe Perez
 *
 */
public interface ITrackService {

	public Authorization insert(Authorization authorization);

	public void update(Authorization authorization);

	public List<Authorization> findAll();
	
	public Optional<Authorization> findById(int id);
	
	public boolean exists(int id);

}
