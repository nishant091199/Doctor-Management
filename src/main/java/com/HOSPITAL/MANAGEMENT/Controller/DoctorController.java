package com.HOSPITAL.MANAGEMENT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HOSPITAL.MANAGEMENT.Exception.IdExists;
import com.HOSPITAL.MANAGEMENT.Model.Doctor;
import com.HOSPITAL.MANAGEMENT.Service.DoctorService;

@RestController
@RequestMapping("/doc")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorservice;
	
	
	
	//add doctors
	@PostMapping("/adddocs")
	public List<Doctor> addAllDoctors(@RequestBody List<Doctor>doctors){
		return doctorservice.addAllDoctors(doctors);
	}
	
	//ADD NEW DOCTOR
		@PostMapping("/ADD")
		public  ResponseEntity addDoctor(@RequestBody Doctor doctor) {
			if(doctorservice.addDoctor(doctor))
				return new ResponseEntity<>(new IdExists().getMessage(),HttpStatus.CONFLICT);
			return ResponseEntity.ok(doctor);
		}
// GET ALL DOCS
	@GetMapping("/all")
	public List<Doctor> findAllDoctos(){
		return doctorservice.getDoctors();
	}
	
	//get doc by id
	
	@GetMapping("/getDocById/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return doctorservice.getDoctorById(id);
	}
	
	
	//get doc by salary
	@GetMapping("/getDocBySalary/{salary}")
	public Doctor findBySalary(@PathVariable int salary) {
		return doctorservice.findBySalary(salary);
	}
	
	// salary descedning
	@GetMapping("/{input}")
	public List<Doctor> getDoctorSort(@PathVariable String input){
		List<Doctor>allDoctors=doctorservice.findDoctorSort(input);
		return allDoctors;
	}
	
	
	
	//update
	
	@PutMapping("/updateDoc")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorservice.updateDoctor(doctor);
	}
	
	//delete
	
	
	@DeleteMapping("/delete/{id}")
	public String DeleteDoc(@PathVariable int id) {
		return doctorservice.DeleteDoc(id);
	}
	
}
