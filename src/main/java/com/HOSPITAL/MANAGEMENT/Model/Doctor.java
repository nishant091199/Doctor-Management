package com.HOSPITAL.MANAGEMENT.Model;

import javax.persistence.Entity;

import javax.persistence.Id;





@Entity


public class Doctor {
	public Doctor() {
		
	}
	@Id
	

	private int id;
	private String name;
	private int salary;
	private String speciality;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Doctor(int id, String name, int salary, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", salary=" + salary + ", speciality=" + speciality + "]";
	}
}
