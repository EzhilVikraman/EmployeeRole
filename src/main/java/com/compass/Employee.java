package com.compass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id", nullable = false)
	private Long id;

	@Column(unique = true, nullable =false )
	@Size(max = 20, min= 3)
	private String username;

	@Column(name = "role", nullable = false)
	@Size(max = 20, min= 3)
	private String role;

	public Employee() {
	}

	public Employee(String username, String role) {

		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}
}
