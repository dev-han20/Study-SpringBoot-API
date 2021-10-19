package org.codingnojam.springbootjpastudy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Developer {

	@Id
	@GeneratedValue
	@Column(name = "developer_id")
	private Long id;

	private String name;

	private int age;

	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
}
