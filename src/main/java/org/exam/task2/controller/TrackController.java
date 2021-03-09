package org.exam.task2.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.exam.task2.entity.Authorization;
import org.exam.task2.exception.NoDataFoundException;
import org.exam.task2.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Task2 
 * 
 * A microservice to keep track of transaction authorizations is needed.
 * Implement the endpoints for insert, update and retrieve each and all
 * authorizations. You should use the Hibernate and Spring frameworks with
 * spring-boot-starter-data-jpa and spring-boot- starter-web modules.
 * Initializer are allowed for this task.
 * 
 * @author Felipe Perez
 *
 */

@RestController
@RequestMapping("/v1/trackTransactions")
public class TrackController {

	@Autowired
	ITrackService trackService;

	@PostMapping()
	public ResponseEntity<Authorization> insert(@Valid @RequestBody Authorization authorization) {
		authorization = trackService.insert(authorization);
		return ResponseEntity.ok(authorization);
	}

	@PutMapping()
	public ResponseEntity<Object> update(@Valid @RequestBody Authorization authorization) {

		if (!this.trackService.exists(authorization.getId())) {
			throw new NoDataFoundException();
		}

		this.trackService.update(authorization);
		return ResponseEntity.ok().build();
	}

	@GetMapping()
	public ResponseEntity<List<Authorization>> findAll() {
		List<Authorization> list = this.trackService.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Authorization> findById(@PathVariable(value = "id") int id){
		Optional<Authorization> authorization = this.trackService.findById(id);
		
		if(!authorization.isPresent())
			throw new NoDataFoundException();
		
		return ResponseEntity.ok(authorization.get());
	}

}
