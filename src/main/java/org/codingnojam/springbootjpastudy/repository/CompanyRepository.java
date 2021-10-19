package org.codingnojam.springbootjpastudy.repository;

import javax.persistence.EntityManager;

import org.codingnojam.springbootjpastudy.domain.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class CompanyRepository {

	private final EntityManager em;

	public Long save(Company company) {
		em.persist(company);
		return company.getId();
	}
}

