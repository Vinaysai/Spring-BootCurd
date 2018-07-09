package com.sprinf.boot.all.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "StudentSample")

public class Student {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "qualification")
	private String qualification;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
}
