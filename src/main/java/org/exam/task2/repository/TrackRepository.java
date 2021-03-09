package org.exam.task2.repository;

import org.exam.task2.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * Implementing Jpa Repository for Authorizations
 * 
 * @author Felipe Perez
 *
 */

public interface TrackRepository extends JpaRepository<Authorization, Integer> {

}
