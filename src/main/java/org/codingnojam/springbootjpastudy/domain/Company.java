package org.codingnojam.springbootjpastudy.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {

	@Id
	@GeneratedValue
	@Column(name = "company_id")
	private Long id;

	private String name;
}
