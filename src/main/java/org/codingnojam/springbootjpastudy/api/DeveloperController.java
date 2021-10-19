package org.codingnojam.springbootjpastudy.api;

import org.codingnojam.springbootjpastudy.domain.Company;
import org.codingnojam.springbootjpastudy.domain.Developer;
import org.codingnojam.springbootjpastudy.repository.CompanyRepository;
import org.codingnojam.springbootjpastudy.repository.DeveloperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
public class DeveloperController {

	private final DeveloperRepository developerRepository;
	private final CompanyRepository companyRepository;

	@GetMapping("/developer-init")
	public DeveloperDTO initDeveloper() {
		// 개발자 객체 생성
		Developer developer = new Developer();
		developer.setAge(30);
		developer.setName("coding-nojam");
		developer.setJob("Back-end");


		// 회사 객체 생성
		Company company = new Company();
		company.setName("woowahan");
		companyRepository.save(company);
		developer.setCompany(company);
		Long id = developerRepository.save(developer);
		Developer findDeveloper = developerRepository.findOneById(id);
		DeveloperDTO developerDTO = new DeveloperDTO(findDeveloper);
		return developerDTO;

	}

	@GetMapping("/developer/{id}")
	public Developer findOneById(@PathVariable("id") Long id) {
		Developer developer = developerRepository.findOneById(id);
		return developer;
	}

	@Getter
	@Setter
	static class DeveloperDTO{
		Long id;
		String name;
		int age;
		String job;
		String companyName;

		public DeveloperDTO(Developer developer) {
			this.id = developer.getId();
			this.name = developer.getName();
			this.age = developer.getAge();
			this.job = developer.getJob();
			this.companyName = developer.getCompany().getName();
		}
	}
}

