package com.HOSPITAL.MANAGEMENT.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.HOSPITAL.MANAGEMENT.Model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {


	Doctor findBySalary(int salary);
	

}
