package com.madushan.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.Transient;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;

	String marks;

	@Transient
	Allocation[] allocations;

	public Allocation[] getAllocations() {
		return allocations;
	}

	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Telephone.class, mappedBy = "employee")
	List<Telephone> telephones;

	public void addTelephone(Telephone tp) {
		telephones.add(tp);
		tp.setEmployee(this);
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "e_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "p_id", referencedColumnName = "id") })
	List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

}
