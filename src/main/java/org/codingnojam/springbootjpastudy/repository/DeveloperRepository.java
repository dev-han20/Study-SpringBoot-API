package org.codingnojam.springbootjpastudy.repository;

import javax.persistence.EntityManager;

import org.codingnojam.springbootjpastudy.domain.Developer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class DeveloperRepository {

	private final EntityManager	em;

	public Developer findOneById(Long id) {
		return em.find(Developer.class, id);
	}

	public void save(Developer developer) {
		em.persist(developer);
	}


}
