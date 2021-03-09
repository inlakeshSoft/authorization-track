package org.exam.task2.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.exam.task2.entity.Authorization;
import org.exam.task2.repository.TrackRepository;
import org.exam.task2.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Service to implement necessary methods to persist and retrieve each and all authorizations.
 * 
 * @author Felipe Perez
 *
 */

@Service
@Transactional
public class TrackService implements ITrackService{

	@Autowired
	TrackRepository trackRepository;

	public Authorization insert(Authorization authorization) {
		authorization = this.trackRepository.save(authorization);
		return authorization;
	}

	public void update(Authorization authorization) {
		this.trackRepository.save(authorization);
	}

	public List<Authorization> findAll() {
		return this.trackRepository.findAll();
	}

	@Override
	public boolean exists(int id) {
		return this.trackRepository.findById(id).isPresent();
	}

	@Override
	public Optional<Authorization> findById(int id) {
		return this.trackRepository.findById(id);
	}

}
