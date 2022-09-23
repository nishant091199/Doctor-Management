package com.HOSPITAL.MANAGEMENT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.HOSPITAL.MANAGEMENT.Model.Doctor;
import com.HOSPITAL.MANAGEMENT.Repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorrepository;
public List<Doctor> getDoctors() {
		
		return doctorrepository.findAll();
	}
public List<Doctor> addAllDoctors(List<Doctor> doctors) {
	
	return doctorrepository.saveAll(doctors);
}

public List<Doctor> findDoctorSort(String input){
	return doctorrepository.findAll(Sort.by(Sort.Direction.DESC,input));
}
public Doctor getDoctorById(int id) {
	
	return doctorrepository.findById(id).orElse(null);
}

public Doctor 	findBySalary(int salary) {
	
	 return doctorrepository.findBySalary(salary);
}


	public boolean  addDoctor(Doctor doct) {
		if(isPresent(doct.getId()))
			return true;
		doctorrepository.save(doct);
	return false;
		
	}
	public boolean isPresent(int id) {
		return doctorrepository.existsById(id);
	}

	



	public Doctor updateDoctor(Doctor doctor) {
		
		 Doctor existingDoc=doctorrepository.findById(doctor.getId()).orElse(null);
		existingDoc.setName(doctor.getName());
		existingDoc.setSalary(doctor.getSalary());
		existingDoc.setSpeciality(doctor.getSpeciality());
		return doctorrepository.save(existingDoc);
	}


	public String DeleteDoc (int id) {
		doctorrepository.deleteById(id);
		return "Doctor has been succesfully deleted from DataBase";	
}
	
	
	
	
	
}
