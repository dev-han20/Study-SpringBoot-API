package org.codingnojam.springbootjpastudy.controller;

import org.codingnojam.springbootjpastudy.domain.Company;
import org.codingnojam.springbootjpastudy.domain.Developer;
import org.codingnojam.springbootjpastudy.repository.DeveloperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeveloperController {

	private final DeveloperRepository developerRepository;

	@PostMapping("/developer/init")
	public void initDeveloper() {
		Developer developer = new Developer();
		developer.setAge(30);
		developer.setName("coding-nojam");

		Company company = new Company();
		company.setName("woowahan");
		developer.setCompany(company);
		developerRepository.save(developer);
	}

	@GetMapping("/developer/{id}")
	public Developer findOneById(@PathVariable("id") Long id) {
		Developer developer = developerRepository.findOneById(id);
		return developer;
	}
}

