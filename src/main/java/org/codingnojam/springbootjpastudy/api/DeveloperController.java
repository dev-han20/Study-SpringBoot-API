package org.codingnojam.springbootjpastudy.api;

import org.codingnojam.springbootjpastudy.domain.Company;
import org.codingnojam.springbootjpastudy.domain.Developer;
import org.codingnojam.springbootjpastudy.repository.CompanyRepository;
import org.codingnojam.springbootjpastudy.repository.DeveloperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DeveloperController {

	private final DeveloperRepository developerRepository;
	private final CompanyRepository companyRepository;

	@GetMapping("/developer-init")
	public Developer initDeveloper() {
		Developer developer = new Developer();
		developer.setAge(30);
		developer.setName("coding-nojam");
		log.debug("ddd:{}","ww");

		Company company = new Company();
		company.setName("woowahan");
		companyRepository.save(company);
		developer.setCompany(company);
		Long id = developerRepository.save(developer);
		return developerRepository.findOneById(id);
	}

	@GetMapping("/developer/{id}")
	public Developer findOneById(@PathVariable("id") Long id) {
		Developer developer = developerRepository.findOneById(id);
		return developer;
	}
}

